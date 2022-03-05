fun main() {
    val n = readLine()!!.toInt()
    val numbers = List(n) { readLine()!!.toInt() }
    println(numbers.minOrNull())
}