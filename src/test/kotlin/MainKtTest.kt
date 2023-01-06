import org.junit.Test

import org.junit.Assert.*
import java.math.RoundingMode
import java.text.DecimalFormat
import ru.netology.*
import ru.netology.calculate

class MainKtTest {

    @Test
    fun calculateVK() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 13_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 13900.0 без комиссии", result)
    }
    @Test
    fun calculateVKLimits() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 33_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateMasterWithFee() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 83_900_00.00
        val card = "MasterCard"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 84423,4руб, комиссия - 523,4 руб", result)


    }
    @Test
    fun calculateMasterWithoutFee() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 72_900_00.00
        val card = "MasterCard"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 72900.0 руб без комиссии", result)


    }
    @Test
    fun calculateMasterLimits() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 100_900_00.00
        val card = "MasterCard"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)


    }
    @Test
    fun calculateVisa() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 13_900_00.00
        val card = "Visa"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 14004,25руб, комиссия - 104,25 руб", result)


    }
    @Test
    fun calculateVisaLimits() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 100_000_00.00
        val amountTransfer = 163_900_00.00
        val card = "Visa"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)


    }
}