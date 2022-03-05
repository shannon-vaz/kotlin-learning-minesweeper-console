fun main() {
    val age = readLine()!!.toInt()
    val acceptableAge = 18..59
    println(age in acceptableAge)
}