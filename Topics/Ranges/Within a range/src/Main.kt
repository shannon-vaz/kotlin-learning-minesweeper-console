fun main() {
    val n1 = readLine()!!.toInt()
    val n2 = readLine()!!.toInt()
    val n3 = readLine()!!.toInt()
    val n4 = readLine()!!.toInt()
    val n5 = readLine()!!.toInt()
    val range1 = n1..n2
    val range2 = n3..n4

    println(n5 in range1 || n5 in range2)
}