package v_builders

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class N37StringAndMapBuildersKtTest {
    @Test fun testBuildMap() {
        val map = task37()
        checkMapContent(map)
    }


    @Test fun testBuildMap2() {
        val map = task37_2()
        checkMapContent(map)

    }

    private fun checkMapContent(map: Map<Int, String>) {
        val expected = HashMap<Int, String>()
        for (i in 0..10) {
            expected[i] = "$i"
        }
        assertEquals("Map should be filled with the right values", expected, map)
    }
}