fun main() {
    val color = readLine()!!
    println(Rainbow.ordinalInRainbow(color))
}

enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet");

    companion object {
        fun ordinalInRainbow(color: String): Int {
            return valueOf(color.uppercase()).ordinal + 1
        }
    }
}