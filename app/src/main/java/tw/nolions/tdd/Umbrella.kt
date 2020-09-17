package tw.nolions.tdd

class Umbrella {
    fun totalPrice(weather: IWeather, count: Int, price: Int): Int {
        var totalPrice = count * price
        if (weather.isSunny()) {
            totalPrice = (totalPrice * 0.9).toInt()
        }
        return totalPrice
    }
}