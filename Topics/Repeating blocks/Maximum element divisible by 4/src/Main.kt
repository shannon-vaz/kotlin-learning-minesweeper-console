fun main() {
    var maxNumDivisibleBy4 = 0
    val numberOfElements = readInt()
    repeat(numberOfElements) {
        val nextNum = readInt()
        if (nextNum % 4 == 0 && nextNum > maxNumDivisibleBy4) {
            maxNumDivisibleBy4 = nextNum
        }
    }

    println(maxNumDivisibleBy4)
}

fun readInt() = readLine()!!.toInt()