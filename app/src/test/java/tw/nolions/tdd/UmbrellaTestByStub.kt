package tw.nolions.tdd

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UmbrellaTestByStub {

    private lateinit var weather: SubWeather
    private lateinit var umbrella: Umbrella

    @Before
    fun setup() {
        weather = SubWeather()
        umbrella = Umbrella()
    }

    @Test
    fun testPrice_sunny() {
        weather.fakeIsSunny = true

        val actual = umbrella.totalPrice(weather, 10, 100)
        Assert.assertEquals(900, actual)
    }

    @Test
    fun testPrice_rain() {
        weather.fakeIsSunny = false

        val actual = umbrella.totalPrice(weather, 10, 100)
        Assert.assertEquals(1000, actual)
    }


    internal class SubWeather : IWeather {
        var fakeIsSunny = false

        override fun isSunny(): Boolean {
            return fakeIsSunny
        }
    }
}

