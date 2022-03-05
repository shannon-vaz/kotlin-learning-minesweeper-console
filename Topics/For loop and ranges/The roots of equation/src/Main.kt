import kotlin.math.pow

fun main() {
    val (a, b, c, d) = List(4) { readLine()!!.toInt() }
    val equation = getEquation(a, b, c, d)
    for (x in 0..1000) {
        if (equation(x) == 0) {
            println(x)
        }
    }
}

fun getEquation(a: Int, b: Int, c: Int, d: Int) = fun(x: Int): Int {
    return a * x.pow(3) + b * x.pow(2) + c * x + d
}

fun Int.pow(exponent: Int): Int = this.toDouble().pow(exponent).toInt()