fun isVowel(c: Char): Boolean {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    return c.lowercaseChar() in vowels
}

fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}