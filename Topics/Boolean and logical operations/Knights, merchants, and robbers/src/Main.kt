fun main() {    
    val firstAnswer = readLine().toBoolean()
    val secondAnswer = readLine().toBoolean()
    val confession = readLine().toBoolean()

    val untrustedStrangers = confession || (firstAnswer xor secondAnswer)
    println(!untrustedStrangers)
}