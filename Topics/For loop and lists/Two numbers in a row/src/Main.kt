fun main() {
    val listSize = readLine()!!.toInt()
    val inputList = MutableList(listSize) { readLine()!!.toInt() }
    val sequence = readLine()!!.split(' ').map { it.toInt() }
    val sequencePresent = checkSequence(inputList, sequence) || checkSequence(inputList, sequence.reversed())
    if (sequencePresent) println("NO") else println("YES")
}

/**
 * Checks whether sequence is present in the list
 */
fun checkSequence(list: List<Int>, sequence: List<Int>): Boolean {
    if (sequence.size > list.size) return false
    val numberOfChecks = list.size - sequence.size + 1
    for (listIndex in 0 until numberOfChecks) {
        var tmpListIndex = listIndex
        var sequenceFound = true
        for (sequenceIndex in sequence.indices) {
            sequenceFound = sequenceFound && list[tmpListIndex++] == sequence[sequenceIndex]
            if (!sequenceFound) break
        }
        if (sequenceFound) return sequenceFound
    }
    return false
}
