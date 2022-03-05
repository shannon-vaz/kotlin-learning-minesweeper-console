fun main() {
    val s1 = readLine()!!
    val operator = readLine()!!
    val s2 = readLine()!!

    when (operator) {
        "equals" -> println(s1 == s2)
        "plus" -> println(s1 + s2)
        "endsWith" -> println(s1.endsWith(s2))
        else -> println("Unknown operation")
    }
}