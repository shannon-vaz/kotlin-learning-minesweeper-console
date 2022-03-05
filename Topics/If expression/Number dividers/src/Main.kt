fun main() {
    val n = readLine()!!.toInt()
    val divisors = listOf(2, 3, 5, 6)
    divisors.forEach { if (n % it == 0) println("Divided by $it") }
}