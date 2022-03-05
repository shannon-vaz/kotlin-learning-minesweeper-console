fun main() {
    val l1 = readChar()
    val l2 = readChar()

    println(l1.equals(l2, ignoreCase = true))
}

fun readChar() = readLine()!!.first()