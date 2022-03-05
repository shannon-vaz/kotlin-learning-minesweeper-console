fun main() {
    val c = readLine()!!.first()
    println(c.isUpperCase() || c.isDigitFrom1to9())
}

fun Char.isDigitFrom1to9() = this.isDigit() && this != '0'