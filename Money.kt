class Money private constructor (
    val amount: Float,
    val isCoin: Boolean
) {
    companion object {
        val coins_10 = Money(0.1f, true)
        val coins_50 = Money(0.5f, true)
        val coins_100 = Money(1f, true)
        val bill_50 = Money(50f, false)
        val bill_100 = Money(100f, false)
        val bill_500 = Money(500f, false)
        val bill_1000 = Money(1000f, false)
    }
    override fun toString(): String {
        if (isCoin and (this.amount < 1)) return "${(100 * amount).toInt()} коп."
        else if (isCoin) return "${amount.toInt()} руб."
        else return "${amount.toInt()} руб."
    }
    
}
