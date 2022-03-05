fun main() {
    val (in1, operator, in3) = readLine()!!.split(" ")
    val n1 = in1.toLong()
    val n2 = in3.toLong()

    when (operator) {
        "+" -> println(n1 + n2)
        "-" -> println(n1 - n2)
        "*" -> println(n1 * n2)
        "/" -> {
            if (n2 == 0L) {
                println("Division by 0!")
            } else {
                println(n1 / n2)
            }
        }
        else -> println("Unknown operator")
    }
}