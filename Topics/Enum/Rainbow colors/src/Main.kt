fun main() {
    val color = readLine()!!
    println(isInRainbow(color))
}

fun isInRainbow(color: String) = color.uppercase() in Rainbow.colors

enum class Rainbow {
    VIOLET, INDIGO, BLUE, GREEN, YELLOW, ORANGE, RED;
    companion object {
        val colors = values().map(Rainbow::name).toSet()
    }
}
