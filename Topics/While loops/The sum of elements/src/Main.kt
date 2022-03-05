fun main() {
    val scanner = java.util.Scanner(System.`in`)
    var input = scanner.nextInt()
    var sum = 0
    while (input != 0) {
        sum += input
        input = scanner.nextInt()
    }
    println(sum)
}