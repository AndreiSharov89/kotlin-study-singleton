import java.util.*
class CoffeeMachine {
    private var water = 0 // миллилитр
    private var milk = 0 // миллилитр
    private var beans = 0 // грамм
    private var scanner = Scanner(System.`in`)
    enum class Coffee(var water: Int,
                      var milk: Int,
                      var beans: Int) {
        CAPPUCCINO(120, 60, 20),
        LATTE(240, 120, 20),
        AMERICANO(120, 0, 10),
        ESPRESSO(60, 0, 10)
    }
    fun start() {
        println("Кофемашина готова к работе")
        do {
            println("Введите команду")
            when (scanner.nextLine().lowercase()) {
                "кофе" -> coffeeMenu()
                "наполнить" -> refill()
                "статус" -> printStatus()
                "выключить" -> {
                    println("До свидания!")
                    return
                }
                else -> println("Неизвестная команда!")
            }
        } while (true)
    }
    private fun coffeeMenu() {
        println("Введите название напитка или \"назад\" для возврата в главное меню")
        when (scanner.nextLine().lowercase()) {
            "эспрессо" -> makeCoffee(Coffee.ESPRESSO)
            "американо" -> makeCoffee(Coffee.AMERICANO)
            "капучино" -> makeCoffee(Coffee.CAPPUCCINO)
            "латте" -> makeCoffee(Coffee.LATTE)
            "назад" -> {}
            else -> println("Рецепт не найден!")
        }
    }
    private fun makeCoffee(coffee: Coffee) {
        if (!isIngredientsEnough(coffee))
            return
        water -= coffee.water
        milk -= coffee.milk
        beans -= coffee.beans
        when (coffee) {
            Coffee.ESPRESSO -> println("Эспрессо готов")
            Coffee.AMERICANO -> println("Американо готов")
            Coffee.CAPPUCCINO -> println("Капучино готов")
            Coffee.LATTE -> println("Латте готов")
        }
    }
    private fun refill() {
        water = 2000
        milk = 1000
        beans = 500
        println("Ингридиенты пополнены")
    }
    private fun printStatus() {
        println("Ингридиентов осталось:")
        println("$water мл воды")
        println("$milk мл молока")
        println("$beans гр кофе")
    }
    private fun isIngredientsEnough(coffee: Coffee): Boolean {
        if (water < coffee.water) {
            println("Недостаточно воды!")
            return false
        }
        if (milk < coffee.milk) {
            println("Недостаточно молока!")
            return false
        }
        if (beans < coffee.beans) {
            println("Недостаточно кофе!")
            return false
        }
        return true
    }
}
