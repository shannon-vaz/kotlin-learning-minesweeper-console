import kotlin.random.Random

fun createDiceGameRandomizer(n: Int): Int {
    var seedFound: Boolean
    var seed = 0
    do {
        seed++
        val r = Random(seed)
        val sequence1Sum = nextDiceSequence(r, n).sum()
        val sequence2Sum = nextDiceSequence(r, n).sum()
        seedFound = sequence2Sum > sequence1Sum
    } while (!seedFound)

    return seed
}

fun nextDiceSequence(r: Random, sequenceLength: Int): List<Int> {
    val min = 1
    val max = 7
    return MutableList(sequenceLength) { r.nextInt(min, max) }
}