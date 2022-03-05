fun main() {
    val cube = MutableList(3) {
        MutableList(3) {
            MutableList(3) { 0 }
        }
    }
    println(cube)
}