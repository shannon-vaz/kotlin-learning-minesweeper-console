fun main() {
    var prefectCmp: Int = 0
    var largerCmp: Int = 0
    var rejectedCmp: Int = 0
    val n = readInt()

    repeat(n) {
        when (readInt()) {
            1 -> largerCmp++
            -1 -> rejectedCmp++
            0 -> prefectCmp++
        }
    }

    println("$prefectCmp $largerCmp $rejectedCmp")
}

fun readInt() = readLine()!!.toInt()