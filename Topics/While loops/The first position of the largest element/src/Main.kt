import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var largestNumber = Int.MIN_VALUE
    var largestNumberPosition = 0
    var currentPosition = 1
    while (scanner.hasNextInt()) {
        val input = scanner.nextInt()
        if (input > largestNumber) {
            largestNumber = input
            largestNumberPosition = currentPosition
        }
        currentPosition++
    }
    println("$largestNumber $largestNumberPosition")
}