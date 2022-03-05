fun main() {
    val minHours = readLine()!!.toInt()
    val maxHours = readLine()!!.toInt()
    val actualHours = readLine()!!.toInt()

    if (actualHours < minHours) {
        println("Deficiency")
    } else if (actualHours > maxHours) {
        println("Excess")
    } else {
        println("Normal")
    }
}