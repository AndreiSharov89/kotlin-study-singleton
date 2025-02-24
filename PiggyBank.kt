object PiggyBank {
    private val moneys: ArrayList<Money> = ArrayList() // список монеток/купюр
    private var isBroken = false // свойство, определяющее, разбита ли копилка

    fun putMoney(money: Money) {
        if (isBroken) {
            println("Вы разбили копилку, вы больше ничего положить туда не можете")
            return
        } // проверьте, не разбита ли копилка
        moneys.add(money)
        println("Добавлено в копилку $money") // добавьте монетку в копилку
    }
    fun shake(): Money? {
        if (isBroken) {
            println("Вы разбили копилку, больше оттуда ничего не вытрясти")
            return null
        } // проверьте, не разбита ли копилка
        for (money in moneys) {
            if (money.isCoin) {
                moneys.remove(money)
                return money
            }
        } 
        return null
    }
    fun smash(): ArrayList<Money> {
        if (!isBroken) {
        isBroken = true // установить флаг, что копилка разбита true
        println("Копилка разбита, вы достали оттуда: $moneys")
        //и вернуть все монетки, которые были в копилке 
        } else {
            moneys.clear()
            println("Копилка разбита, вы достали оттуда:")}
        return moneys
    }
}
