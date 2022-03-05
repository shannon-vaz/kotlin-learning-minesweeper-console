fun main() {
    val size = readLine()!!.toInt()
    val numbers = MutableList(size) { readLine()!!.toInt() }

    var maxIndex = 0
    for (i in numbers.indices) {
        if (numbers[maxIndex] < numbers[i]) maxIndex = i
    }
    println(maxIndex)
}