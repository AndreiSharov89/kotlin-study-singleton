import kotlin.random.Random

class DiceRollerV2 {

    // сделайте интерфейс OnRollCallback функциональным
    fun interface OnRollCallback {
        fun call(firstDiceValue: Int, secondDiceValue: Int)
    }

    // сделайте интерфейс OnDoubleCallback функциональным
    fun interface OnDoubleCallback {
        fun call(diceValue: Int)
    }

    private var onRollCallback: OnRollCallback? = null
    private var onDoubleCallback: OnDoubleCallback? = null

    fun setCallbacks(onRollCallback: OnRollCallback, onDoubleCallback: OnDoubleCallback) {
        this.onRollCallback = onRollCallback
        this.onDoubleCallback = onDoubleCallback
    }

    fun roll() {
        if (onRollCallback == null || onDoubleCallback == null) {
            println("Вы должны вызвать функцию setCallbacks() прежде чем бросать кубики")
            return
        }

        val firstDiceValue = Random.nextInt(1, 7)
        val secondDiceValue = Random.nextInt(1, 7)

        if (firstDiceValue != secondDiceValue) {
            onRollCallback?.call(firstDiceValue, secondDiceValue)
        } else {
            onDoubleCallback?.call(firstDiceValue)
        }
    }
}

fun main() {
    // ваш код здесь
    val diceRoller = DiceRollerV2()
    var rolls = 0
    diceRoller.setCallbacks(
        onRollCallback = { firstDiceValue, secondDiceValue ->
            println("На кубиках выпало $firstDiceValue и $secondDiceValue")
        },
        onDoubleCallback = { diceValue ->
            println("Ура!!! Дубль на ${diceValue}-ах! Бросаем ещё раз")
            diceRoller.roll()
        }
    )
    while (rolls < 10){
        diceRoller.roll()
        rolls++
    }
}
