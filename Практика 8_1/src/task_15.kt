import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

fun main(){
    // 15 задание
    print("Введите имя студента: ")
    val name = readLine()!!.toString()

    print("Введите предмет: ")
    val nameOfPredmet = readLine()!!.toString()

    print("Введите дату экзамена (день-месяц-год): ")
    val dateString = readLine()!!
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    var date: Date? = null
    try {
        date = dateFormat.parse(dateString)
        if (date > Calendar.getInstance().time) throw Exception("Неверный ввод даты.")
    }
    catch (e: ParseException){
        println("Неверный ввод даты.")
        exitProcess(1)
    }

    var grade = 0
    print("Введите оценку: ")
    try {
        grade = readLine()!!.toInt()
        if (grade < 1 || grade > 5) throw Exception("Неверный ввод оценки.")
    }
    catch (e: NumberFormatException){
        println("Неверный ввод оценки.")
        exitProcess(1)
    }

    val one = Exam(name, nameOfPredmet, date!!, grade)
    println("Имя: ${one.name}, Предмет: ${nameOfPredmet}, Дата: ${dateFormat.format(one.date)}, Оценка: ${one.grade}")

    // 1 функция
    print("Введите новую оценку для студента: ")
    val newGrade = readLine()!!.toInt()
    if (newGrade < 1 || newGrade > 5) println("Ошибка ввода оценки.")
    else one.changeGrade(newGrade)

    // 2 функция
    println(one.showStudentGrade())

    // 3 функция
    println("Прошло дней с даты экзамена: ${one.calculateDaysExam()}")
}