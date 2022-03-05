fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    var product = 1L
    for (i in a until b) {
        product *= i
    }
    println(product)
}