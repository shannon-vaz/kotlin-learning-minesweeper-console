import kotlin.random.Random

const val DAYS = 7
const val MIN_TEMP = 20
const val MAX_TEMP = 31

fun generateTemperature(seed: Int): String {
    val r = Random(seed)
    return MutableList(DAYS) { r.nextInt(MIN_TEMP, MAX_TEMP) }
        .joinToString(" ")
}