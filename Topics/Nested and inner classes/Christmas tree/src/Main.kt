class ChristmasTree(var color: String) {

    // create function putTreeTopper()
    fun putTreeTopper(color: String) {
        val topper = this.TreeTopper(color)
        topper.sparkle()
    }

    inner class TreeTopper(var color: String) {

        // create function sparkle()
        fun sparkle() {
            println("The sparkling ${this@TreeTopper.color} tree topper looks stunning on the ${this@ChristmasTree.color}" +
                    " Christmas tree!")
        }
    }
}