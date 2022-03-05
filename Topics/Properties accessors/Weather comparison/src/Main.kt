class City(val name: String) {
    var degrees: Int = 0
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

    var coldestCities = mutableListOf<City>()
    for (city in listOf(firstCity, secondCity, thirdCity)) {
        if (city.degrees > 57 || city.degrees < -92) {
            city.degrees = when (city.name) {
                "Moscow" -> 5
                "Hanoi" -> 20
                "Dubai" -> 30
                else -> city.degrees
            }
        }
        if (coldestCities.isEmpty()) {
            coldestCities.add(city)
            continue
        }
        if (coldestCities[0].degrees > city.degrees) {
            coldestCities = mutableListOf(city)
        } else if (coldestCities[0].degrees == city.degrees) {
            coldestCities.add(city)
        }
    }
    val coldestCityName = if (coldestCities.size > 1) "neither" else coldestCities[0].name
    print(coldestCityName)
}