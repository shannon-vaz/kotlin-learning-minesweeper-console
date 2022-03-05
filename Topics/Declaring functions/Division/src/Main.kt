fun divide(n1: Long, n2: Long): Double {
    return n1.toDouble()/n2
}

/* Do not change code below */
fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    println(divide(a, b))
}