fun main() {
    val c1 = readChar()
    val c2 = readChar()
    val c3 = readChar()
    val c4 = readChar()

    val chars = listOf(c1, c2, c3, c4)
    chars.forEach { c -> println(c.isDigit()) }
}

fun readChar() = readLine()!!.first()