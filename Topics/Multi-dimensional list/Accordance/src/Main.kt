fun main() {
    val mat = MutableList(2) { i ->
        MutableList(3) { j -> "[$i][$j]" }
    }

    println(mat)
}