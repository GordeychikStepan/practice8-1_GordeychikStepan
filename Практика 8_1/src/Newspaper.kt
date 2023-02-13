import java.util.*
import java.util.concurrent.TimeUnit

class Newspaper(var name: String, var number: Int, var date: Date) {

    internal fun getName(): String{
        return this.name
    }

    internal fun setName(name: String){
        this.name = name
    }

    internal fun calculateDays(): Long{
        val correctDate = Calendar.getInstance().time
        val diff = correctDate.time - date.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }
}