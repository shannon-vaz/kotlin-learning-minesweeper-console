fun main() {
    var countOfPositives = 0
    val lengthOfSequence = readInt()
    repeat(lengthOfSequence) {
        val nextNum = readInt()
        if (nextNum > 0) countOfPositives++
    }

    println(countOfPositives)
}

fun readInt() = readLine()!!.toInt()