class Block(val color: String) {
    object BlockProperties {
        var length = 1
        var width = 1

        fun blocksInBox(length: Int, width: Int): Int {
            return (length / this.length) * (width / this.width)
        }
    }
}