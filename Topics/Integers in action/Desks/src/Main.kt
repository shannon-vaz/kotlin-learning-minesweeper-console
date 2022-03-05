import kotlin.math.ceil

const val NUM_GROUPS = 3
const val DESK_CAPACITY = 2

fun main() {
    val studentGroupSizes = MutableList(NUM_GROUPS) { readLine()!!.toInt() }
    val minimumDesks =
        studentGroupSizes.sumOf { ceil(it.toDouble() / DESK_CAPACITY).toInt() }
    println(minimumDesks)
}