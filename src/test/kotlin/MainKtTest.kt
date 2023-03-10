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
        assertEquals(TRANSFERAMOUNT + 13900, result)
    }
    @Test
    fun calculateVKLimitsDay() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 33_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals(ABOVELIMINT, result)
    }
    @Test
    fun calculateVKLimitsMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 45_000_00.00
        val amountTransfer = 13_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals(ABOVELIMINT, result)
    }
    @Test
    fun calculateVKLimitsDayPlusMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 38_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals(ABOVELIMINT, result)
    }
    @Test
    fun calculateVKDayPlusMonth() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 10_000_00.00
        val amountTransfer = 8_900_00.00

        val result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals(TRANSFERAMOUNT + 8900, result)
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
        assertEquals(TRANSFERAMOUNT + df.format(84423.4) + FEE + df.format(523.4), result)
        //assertEquals("?????????? ???????????????? ???????????????? - 84423,4??????, ???????????????? - 523,4 ??????", result)


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
        assertEquals(TRANSFERAMOUNT + df.format(75470) + FEE + df.format(470), result)
        //assertEquals("?????????? ???????????????? ???????????????? - 75470??????, ???????????????? - 470 ??????", result)


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
        assertEquals(TRANSFERAMOUNT + 72900, result)


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
        assertEquals(ABOVELIMINT, result)
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
        assertEquals(ABOVELIMINT, result)


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
        assertEquals(TRANSFERAMOUNT + df.format(14004.25) + FEE + df.format(104.25), result)
        //assertEquals("?????????? ???????????????? ???????????????? - 14004,25??????, ???????????????? - 104,25 ??????", result)
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
        assertEquals(TRANSFERAMOUNT + df.format(935.0) + FEE + df.format(35), result)
        //assertEquals("?????????? ???????????????? ???????????????? - 935.0??????, ???????????????? - 35 ??????", result)


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
        assertEquals(ABOVELIMINT, result)
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
        assertEquals(ABOVELIMINT, result)
    }
}