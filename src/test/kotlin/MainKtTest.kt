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
    fun calculateVKLimitsDay() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 33_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateVKLimitsMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 45_000_00.00
        val amountTransfer = 13_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateVKLimitsDayPlusMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 38_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateVKDayPlusMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 8_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 8900.0 без комиссии", result)
    }
    @Test
    fun calculateMasterWithFee() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 83_900_00.00
        val card = "MasterCard"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val beforeFee = 75_000_00.00

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer ,
            amountTransfer = amountTransfer, dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee)
        assertEquals("сумма перевода составит - 84423,4руб, комиссия - 523,4 руб", result)


    }
    @Test
    fun calculateMasterWithFeeMin() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 75_000_00.00
        val card = "MasterCard"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val beforeFee = 75_000_00.00

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer ,
            amountTransfer = amountTransfer, dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee)
        assertEquals("сумма перевода составит - 75470руб, комиссия - 470 руб", result)


    }
    @Test
    fun calculateMasterWithoutFee() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 72_900_00.00
        val card = "MasterCard"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val beforeFee = 75_000_00.00

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee)
        assertEquals("сумма перевода составит - 72900.0 руб без комиссии", result)


    }
    @Test
    fun calculateMasterLimits() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 100_900_00.00
        val card = "MasterCard"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val beforeFee = 75_000_00.00

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateMasterDayLimit() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 160_900_00.00
        val card = "MasterCard"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val beforeFee = 75_000_00.00

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer,
            beforeFee = beforeFee)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)


    }
    @Test
    fun calculateVisa() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 13_900_00.00
        val card = "Visa"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer)
        assertEquals("сумма перевода составит - 14004,25руб, комиссия - 104,25 руб", result)
    }
    @Test
    fun calculateVisaMinFee() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 900_00.00
        val card = "Visa"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer)
        assertEquals("сумма перевода составит - 935.0руб, комиссия - 35 руб", result)


    }
    @Test
    fun calculateVisaLimits() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 100_000_00.00
        val amountTransfer = 163_900_00.00
        val card = "Visa"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
    @Test
    fun calculateVisaLimitsMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 600_000_00.00
        val amountTransfer = 13_900_00.00
        val card = "Visa"
        val dayCardLimitTransfer = 150_000_00.00
        val monthCardLimitTransfer = 600_000_00.00
        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer,
            dayCardLimitTransfer = dayCardLimitTransfer, monthCardLimitTransfer = monthCardLimitTransfer)
        assertEquals("Вы превысили лимиты! Перевод не осуществлён!", result)
    }
}