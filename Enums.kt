enum class Week(val localizedName: String){
    MONDAY("Понедельник"), 
    TUESDAY("Вторник"), 
    WEDNESDAY("Среда"), 
    THURSDAY("Четверг"), 
    FRIDAY("Пятница"), 
    SATURDAY("Суббота"), 
    SUNDAY("Воскресенье");

    fun isWeekend(): String{
        when(this){
            MONDAY -> return "будний"
            TUESDAY -> return "будний"
            WEDNESDAY -> return "будний"
            THURSDAY -> return "будний" 
            FRIDAY -> return "будний"
            SATURDAY -> return "выходной"
            SUNDAY -> return "выходной"
        }
    }
}
fun main(){
    Week.values().forEach{println("${it.localizedName} - ${it.isWeekend()} день")}
    return
}
