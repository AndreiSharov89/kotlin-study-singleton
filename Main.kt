fun main() {
    // Получаем копилку
    val piggyBank = PiggyBank.instance
    // Положим деньги в копилку
    piggyBank.putMoney(Money.coins_10)
    piggyBank.putMoney(Money.coins_50)
    piggyBank.putMoney(Money.bill_50)
    // Попробуем потрясти копилку
    println(piggyBank.shake()) // Выведет монетку (если она есть)
    // Разбиваем копилку
    val allMoney = piggyBank.smash() // Копилка разбита, все деньги из копилки возвращаются
    // Попробуем снова положить деньги (копилка разбита)
    piggyBank.putMoney(Money.coins_10)
}
