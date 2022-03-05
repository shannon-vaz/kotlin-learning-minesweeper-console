fun main() {
    val n1 = readInt()
    val n2 = readInt()
    val n3 = readInt()
    val inputs = listOf(n1, n2, n3)
    val onlyOnePositive = inputs.fold(0) { acc, i -> if (i.isPositive()) acc + 1 else acc } == 1

    if (onlyOnePositive) {
        println("true")
    } else {
        println("false")
    }
}

fun Int.isPositive() = this > 0
fun readInt() = readLine()!!.toInt()