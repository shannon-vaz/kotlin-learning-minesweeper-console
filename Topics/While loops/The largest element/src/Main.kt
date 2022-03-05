import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var input = scanner.nextInt()
    var max = input

    while (input != 0) {
        max = if (input > max) input else max
        input = scanner.nextInt()
    }
    println(max)
}