import org.junit.Test

import org.junit.Assert.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainKtTest {

    @Test
    fun calculate() {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        // лимиты в копейках
        val dayCardLimitTransfer = 150_000_00
        val monthCardLimitTransfer = 600_000_00
        val beforeFee = 75_000_00
        val vkPerOnceLimit = 15_000_00
        val vkPerMonthLimit = 40_000_00
    }
}