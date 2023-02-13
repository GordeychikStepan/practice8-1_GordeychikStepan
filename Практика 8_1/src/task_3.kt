import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

fun main(){
    // 3 задание
    print("Введите имя газеты: ")
    val name = readLine()!!.toString()

    var number = 0
    print("Введите номер газеты: ")
    try {
        number = readLine()!!.toInt()
        if (number < 1) throw Exception("Неверный ввод номера.")
    }
    catch (e: NumberFormatException){
        println("Неверный ввод номера.")
        exitProcess(1)
    }

    print("Введите дату газеты (день-месяц-год): ")
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

    val one = Newspaper(name, number, date!!)

    println("Имя: ${one.name}, Номер: ${one.number}, Дата: ${dateFormat.format(one.date)}")

    // 1 функция
    println("Имя: ${one.getName()}")

    // 2 функция
    one.setName("NY-Times")
    println("Измененное имя: ${one.getName()}")

    // 3 функция
    println("Возраст газеты: ${one.calculateDays()} дн.")
}
