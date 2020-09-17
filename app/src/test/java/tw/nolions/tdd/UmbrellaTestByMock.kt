package tw.nolions.tdd

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UmbrellaTestByMock {
    private lateinit var umbrella: Umbrella
    private lateinit var weather: Weather

    @Before
    fun setup() {
        umbrella = Umbrella()
        weather = mockk<Weather>()
    }

    @Test
    fun testPrice_sunny() {
        every { weather.isSunny() } returns true
        val actual = umbrella.totalPrice(weather, 10, 100)

        Assert.assertEquals(900, actual)
    }

    @Test
    fun testPrice_rain() {
        every { weather.isSunny() } returns false
        val actual = umbrella.totalPrice(weather, 10, 100)

        Assert.assertEquals(1000, actual)
    }
}