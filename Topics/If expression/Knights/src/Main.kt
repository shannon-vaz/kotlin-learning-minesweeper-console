import kotlin.math.abs

fun main() {
    val (x1, y1) = readLine()!!.split(" ").map { it.toInt() }
    val (x2, y2) = readLine()!!.split(" ").map { it.toInt() }
    val knightsBeatEachOther = abs(x2 - x1) * abs(y2 - y1) == 2
    println(if (knightsBeatEachOther) "YES" else "NO")
}