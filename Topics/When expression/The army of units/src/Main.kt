fun main() {
    val noOfUnits = readLine()!!.toInt()

    when {
        noOfUnits < 1 -> println("no army")
        noOfUnits in 1..4 -> println("few")
        noOfUnits in 5..9 -> println("several")
        noOfUnits in 10..19 -> println("pack")
        noOfUnits in 20..49 -> println("lots")
        noOfUnits in 50..99 -> println("horde")
        noOfUnits in 100..249 -> println("throng")
        noOfUnits in 250..499 -> println("swarm")
        noOfUnits in 500..999 -> println("zounds")
        else -> println("legion")
    }
}