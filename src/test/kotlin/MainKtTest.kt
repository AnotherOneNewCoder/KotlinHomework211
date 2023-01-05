import org.junit.Test

import org.junit.Assert.*
import java.math.RoundingMode
import java.text.DecimalFormat

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
    fun calculateMaster() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 500_000_00.00
        val amountTransfer = 83_900_00.00
        val card = "MasterCard"

        val result = calculate(typeCard = card, currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 84423,4руб, комиссия - 523,4 руб", result)


    }

}