fun main() {
    val input = readLine()!!
    println(decode(input))
}

fun decode(str: String): String = when (str.firstOrNull()) {
    'i' -> (str.drop(1).toInt() + 1).toString()
    's' -> str.drop(1).reversed()
    else -> str
}