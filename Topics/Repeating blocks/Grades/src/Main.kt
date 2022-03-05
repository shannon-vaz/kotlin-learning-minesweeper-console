fun main() {
    val noOfStudents = readInt()
    var d = 0
    var c = 0
    var b = 0
    var a = 0

    repeat(noOfStudents) {
        when (readInt()) {
            2 -> d++
            3 -> c++
            4 -> b++
            5 -> a++
        }
    }

    println("$d $c $b $a")
}

fun readInt() = readLine()!!.toInt()