fun main() {
    val n = readLine()!!.toInt()
    val numbers = mutableListOf<Int>()
    repeat(n) {
        numbers.add(readLine()!!.toInt())
    }

    var isSorted = true
    for (i in 0 until numbers.size - 1) {
        isSorted = isSorted && (numbers[i] < numbers[i + 1])
    }
    if (isSorted) println("YES") else println("NO")
}