fun main() {
    val numbers = MutableList(100) { index ->
        val updatedIndex = index + 1
        if (updatedIndex == 1 || updatedIndex == 10 || updatedIndex == 100)
            updatedIndex
        else 0
    }

    // do not touch the lines below 
    println(numbers.joinToString())
}