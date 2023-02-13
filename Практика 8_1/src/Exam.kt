import java.util.*
import java.util.concurrent.TimeUnit

class Exam(var name: String, var nameOfPredmet: String, var date: Date, var grade: Int) {

    fun changeGrade(newGrade: Int) {
        grade = newGrade
    }

    fun showStudentGrade(): String {
        return "Студент: $name, оценка: $grade"
    }

    internal fun calculateDaysExam(): Long{
        val correctDate = Calendar.getInstance().time
        val diff = correctDate.time - date.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }
}