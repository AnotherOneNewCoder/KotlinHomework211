import org.junit.Test

import org.junit.Assert.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainKtTest {

    @Test
    fun calculateVK() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val  currentMonthTransfer = 23_000_00.00
        val amountTransfer = 13_900_00.00

        var result = calculate(currentMonthTransfer = currentMonthTransfer , amountTransfer = amountTransfer)
        assertEquals("сумма перевода составит - 13900.0 без комиссии", result)


    }
}