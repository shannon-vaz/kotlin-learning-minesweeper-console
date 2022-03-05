package minesweeper

data class Cell(
    var type: CellType,
    var cellPosition: CellPosition,
    var surroundingMines: Int = 0,
    var isMarked: Boolean = false,
    var isExplored: Boolean = false,
) {
    val symbol: Char
        get() {
            if (isMarked) return '*'
            if (!isExplored) return '.'
            return when (type) {
                CellType.MINE -> 'X'
                CellType.SAFE_ZONE -> if (surroundingMines > 0) {
                    surroundingMines.digitToChar()
                } else {
                    '/'
                }
            }
        }


    val isMine: Boolean
        get() = type == CellType.MINE

    val isSafezone: Boolean
        get() = type == CellType.SAFE_ZONE
}

enum class CellType {
    MINE, SAFE_ZONE
}

enum class CellPosition {
    TOP, RIGHT, BOTTOM, LEFT, MIDDLE, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
}