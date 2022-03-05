fun main() {
    val size = readLine()!!.toInt()
    val numbers = MutableList(size) { readLine()!!.toInt() }
    val x = readLine()!!.toInt()
    var count = 0

    for (n in numbers) {
        if (x == n) count++
    }
    println(count)
}