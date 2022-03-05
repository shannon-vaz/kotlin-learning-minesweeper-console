fun main() {
    val count = readLine()!!.toInt()
    var i = 0
    var nextNumInSequence = 1
    var nextNumRemainingPrints = nextNumInSequence
    while (i < count) {
        print("$nextNumInSequence ")
        nextNumRemainingPrints--
        if (nextNumRemainingPrints == 0) {
            nextNumInSequence++
            nextNumRemainingPrints = nextNumInSequence
        }
        i++
    }
}