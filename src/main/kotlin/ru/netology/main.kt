package ru.netology
import java.util.*
import java.math.RoundingMode
import java.text.DecimalFormat
fun main() {
    val dayCardLimitTransfer = 150_000_00.00
    val monthCardLimitTransfer = 600_000_00.00
    val beforeFee = 75_000_00.00

    val amount = Scanner(System.`in`).useLocale(Locale.US) // использую точку как delimiter, а не запятую

    while (true){
        println("Введите сумму перевода в рублях: ")
        val userInput = (amount.nextDouble()*100); // сразу перевожу в копейки.
        println(calculate("MasterCard", amountTransfer = userInput, dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee))
        println(calculate("Мир",amountTransfer = userInput, dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer))
        println(calculate(amountTransfer = userInput))

    }

}
fun calculate(typeCard :String = "VK Pay", currentMonthTransfer: Double = 0.0, amountTransfer : Double, dayCardLimitTransfer : Double = 15_000_00.00,
                monthCardLimitTransfer: Double = 40_000_00.00, beforeFee: Double = 0.0): String {
    // для округления
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    // лимиты в копейках
//    val dayCardLimitTransfer = 150_000_00
//    val monthCardLimitTransfer = 600_000_00
//    val beforeFee = 75_000_00
//    val vkPerOnceLimit = 15_000_00
//    val vkPerMonthLimit = 40_000_00


    when {
        (typeCard == "MasterCard" || typeCard == "Maestro") -> return when {
            (amountTransfer < dayCardLimitTransfer
                    && amountTransfer < beforeFee &&
                    currentMonthTransfer < monthCardLimitTransfer &&
                    (amountTransfer + currentMonthTransfer) < monthCardLimitTransfer) -> "сумма перевода составит - ${amountTransfer / 100} руб без комиссии"

            (amountTransfer < dayCardLimitTransfer &&
                    amountTransfer >= beforeFee &&
                    currentMonthTransfer < monthCardLimitTransfer &&
                    (amountTransfer + currentMonthTransfer) < monthCardLimitTransfer) -> "сумма перевода составит - ${
                df.format(
                    (amountTransfer * 1.006 + 2000) / 100
                )
            }руб, комиссия - " +
                    "${df.format((amountTransfer * 0.006 + 2000) / 100)} руб"

            else -> "Вы превысили лимиты! Перевод не осуществлён!"
        }

        (typeCard == "Visa" || typeCard == "Мир") -> return when {
            (amountTransfer < dayCardLimitTransfer &&
                    currentMonthTransfer < monthCardLimitTransfer &&
                    (amountTransfer + currentMonthTransfer) < monthCardLimitTransfer) -> when {
                (amountTransfer * 0.0075) < 3500 -> "сумма перевода составит - ${(amountTransfer + 3500) / 100}руб, комиссия - 35 руб"
                else -> "сумма перевода составит - ${df.format((amountTransfer * 1.0075) / 100)}руб, комиссия - ${
                    df.format(
                        (amountTransfer * 0.0075) / 100
                    )
                } руб"
            }

            else -> "Вы превысили лимиты! Перевод не осуществлён!"

        }

        else -> return when {
            (amountTransfer < dayCardLimitTransfer &&
                    currentMonthTransfer < monthCardLimitTransfer
                    && (amountTransfer + currentMonthTransfer) < monthCardLimitTransfer) ->
                "сумма перевода составит - ${amountTransfer / 100} без комиссии"

            else -> "Вы превысили лимиты! Перевод не осуществлён!"
        }

    }

}