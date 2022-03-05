import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    val r = Random(seed)
    repeat(10) {
        randomPassword += r.nextInt(33, 127).toChar()
    }
	return randomPassword
}