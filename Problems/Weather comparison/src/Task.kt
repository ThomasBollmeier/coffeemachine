data class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value in -92..57) {
                value
            } else {
                when (name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> value
                }
            }
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val cities = listOf(firstCity, secondCity, thirdCity)
            .sortedBy { it.degrees }
    val lowestTempCities = cities.filter { it.degrees == cities[0].degrees }

    print(if (lowestTempCities.size == 1) {
        lowestTempCities[0].name
    } else {
        "neither"
    })
}