fun main() {
    val spellingToDigit = mapOf(
        Pair("one", 1),
        Pair("two", 2),
        Pair("three", 3),
        Pair("four", 4),
        Pair("five", 5),
        Pair("six", 6),
        Pair("seven", 7),
        Pair("eight", 8),
        Pair("nine", 9),
    )

    val input = readLine()!!
    println(spellingToDigit[input])
}