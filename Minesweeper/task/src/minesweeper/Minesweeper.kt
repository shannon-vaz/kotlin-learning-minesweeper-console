package minesweeper

import kotlin.random.Random

class Minesweeper(private val fieldSize: Int, private val noOfMines: Int) {
    val won: Boolean
        get() {
            // win if all mine positions are guessed correctly
            // or if all safe cells are opened correctly and only mines are unexplored
            return correctMarks == noOfMines && wrongMarks == 0 ||
                    unexploredCells == noOfMines
        }

    var lost: Boolean = false

    val gameOver
        get() = won || lost

    private var correctMarks = 0
    private var wrongMarks = 0
    private val totalCells = fieldSize * fieldSize
    private var exploredCells = 0
    private val unexploredCells
        get() = totalCells - exploredCells

    private val mineField: MutableList<MutableList<Cell>> =
        MutableList(fieldSize) { row ->
            MutableList(fieldSize) { col ->
                val cellPosition = computeCellPosition(row, col)
                Cell(CellType.SAFE_ZONE, cellPosition)
            }
        }

    init {
        placeMines()
        countMinesAroundEmptyCells()
    }

    private fun computeCellPosition(
        row: Int,
        col: Int
    ) = when {
        row == 0 && col == 0 -> CellPosition.TOP_LEFT
        row == 0 && col == fieldSize - 1 -> CellPosition.TOP_RIGHT
        row == fieldSize - 1 && col == 0 -> CellPosition.BOTTOM_LEFT
        row == fieldSize - 1 && col == fieldSize - 1 -> CellPosition.BOTTOM_RIGHT
        row == 0 -> CellPosition.TOP
        row == fieldSize - 1 -> CellPosition.BOTTOM
        col == 0 -> CellPosition.LEFT
        col == fieldSize - 1 -> CellPosition.RIGHT
        else -> CellPosition.MIDDLE
    }

    private fun placeMines() {
        val minePositions = generateMinePositions()
        var currentPosition = 0
        for (i in mineField.indices) {
            for (j in mineField[i].indices) {
                if (currentPosition++ in minePositions) {
                    mineField[i][j] = mineField[i][j].copy(type = CellType.MINE)
                }
            }
        }
    }

    private fun generateMinePositions(): Set<Int> {
        val maxPosition = fieldSize * fieldSize
        val distinctMinePositions = mutableSetOf<Int>()
        while (distinctMinePositions.size < noOfMines) {
            distinctMinePositions.add(Random.nextInt(maxPosition))
        }
        return distinctMinePositions
    }

    private fun countMinesAroundEmptyCells() {
        for (row in mineField.indices) {
            for (col in mineField[row].indices) {
                val cell = mineField[row][col]
                if (cell.isMine) continue
                cell.surroundingMines = countMinesAroundCell(cell, row, col)
            }
        }
    }

    private fun countMinesAroundCell(
        cell: Cell,
        row: Int,
        col: Int
    ) = when (cell.cellPosition) {
        // if current position is in middle, check top, right, bottom, left, top-left, top-right, bottom-left, bottom-right
        CellPosition.MIDDLE -> {
            var mineCount = 0
            if (topLeftIsMine(row, col)) mineCount++
            if (topIsMine(row, col)) mineCount++
            if (topRightIsMine(row, col)) mineCount++
            if (bottomLeftIsMine(row, col)) mineCount++
            if (bottomIsMine(row, col)) mineCount++
            if (bottomRightIsMine(row, col)) mineCount++
            if (leftIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is top-left corner, check right, bottom-right, bottom
        CellPosition.TOP_LEFT -> {
            var mineCount = 0
            if (bottomIsMine(row, col)) mineCount++
            if (bottomRightIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is top-right corner, check left, bottom-left, bottom
        CellPosition.TOP_RIGHT -> {
            var mineCount = 0
            if (bottomLeftIsMine(row, col)) mineCount++
            if (bottomIsMine(row, col)) mineCount++
            if (leftIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is bottom-left corner, check top, top-right, right
        CellPosition.BOTTOM_LEFT -> {
            var mineCount = 0
            if (topIsMine(row, col)) mineCount++
            if (topRightIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is bottom-right corner, check top, top-left, left
        CellPosition.BOTTOM_RIGHT -> {
            var mineCount = 0
            if (topLeftIsMine(row, col)) mineCount++
            if (topIsMine(row, col)) mineCount++
            if (leftIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is top, check left, bottom-left, bottom, bottom-right, right
        CellPosition.TOP -> {
            var mineCount = 0
            if (leftIsMine(row, col)) mineCount++
            if (bottomLeftIsMine(row, col)) mineCount++
            if (bottomIsMine(row, col)) mineCount++
            if (bottomRightIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is bottom, check left, top-left, top, top-right, right
        CellPosition.BOTTOM -> {
            var mineCount = 0
            if (leftIsMine(row, col)) mineCount++
            if (topLeftIsMine(row, col)) mineCount++
            if (topIsMine(row, col)) mineCount++
            if (topRightIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is left, check top, top-right, right, bottom-right, bottom
        CellPosition.LEFT -> {
            var mineCount = 0
            if (topIsMine(row, col)) mineCount++
            if (topRightIsMine(row, col)) mineCount++
            if (rightIsMine(row, col)) mineCount++
            if (bottomRightIsMine(row, col)) mineCount++
            if (bottomIsMine(row, col)) mineCount++
            mineCount
        }
        // if current position is right, check top, top-left, left, bottom-left, bottom
        CellPosition.RIGHT -> {
            var mineCount = 0
            if (topIsMine(row, col)) mineCount++
            if (topLeftIsMine(row, col)) mineCount++
            if (leftIsMine(row, col)) mineCount++
            if (bottomLeftIsMine(row, col)) mineCount++
            if (bottomIsMine(row, col)) mineCount++
            mineCount
        }
    }

    private fun topLeftIsMine(row: Int, col: Int) =
        mineField[row - 1][col - 1].isMine

    private fun topRightIsMine(row: Int, col: Int) =
        mineField[row - 1][col + 1].isMine

    private fun bottomLeftIsMine(row: Int, col: Int) =
        mineField[row + 1][col - 1].isMine

    private fun bottomRightIsMine(row: Int, col: Int) =
        mineField[row + 1][col + 1].isMine

    private fun topIsMine(row: Int, col: Int) = mineField[row - 1][col].isMine

    private fun bottomIsMine(row: Int, col: Int) =
        mineField[row + 1][col].isMine

    private fun rightIsMine(row: Int, col: Int) = mineField[row][col + 1].isMine

    private fun leftIsMine(row: Int, col: Int) = mineField[row][col - 1].isMine

    fun printMinefield() {
        print(" │")
        repeat(fieldSize) { print(it + 1) }
        println("│")
        println(blankRow())
        for (row in mineField.indices) {
            print("${row + 1}│")
            for (col in mineField[row].indices) {
                val cell = mineField[row][col]
                print(cell.symbol)
            }
            println("│")
        }
        println(blankRow())
    }

    private fun blankRow() = "—│${"—".repeat(fieldSize)}│"

    fun playMove(move: GameMove): Boolean {
        if (move.col !in 1..fieldSize || move.row !in 1..fieldSize) {
            throw IllegalArgumentException("Coordinates out of bounds of minefield size")
        }
        // convert row and col in range: 0 to fieldSize
        val col = move.col - 1
        val row = move.row - 1
        return if (move.command == GameMove.Type.MARK) {
            mark(col, row)
        } else {
            explore(col, row)
        }
    }

    private fun explore(col: Int, row: Int): Boolean {
        val cell = mineField[row][col]
        if (cell.isExplored) return false
        if (cell.isMine) {
            revealMines()
            lost = true
            return true
        }
        exploreEmptyCellsRecursively(col, row)
        return true
    }

    private fun revealMines() {
        for (row in mineField) {
            for (cell in row) {
                cell.isExplored = true
                cell.isMarked = false
            }
        }
    }

    private fun exploreEmptyCellsRecursively(col: Int, row: Int) {
        // we have reached outside the field
        if (row !in 0 until fieldSize || col !in 0 until fieldSize) return
        val cell = mineField[row][col]
        if (cell.isExplored) return
        cell.isExplored = true
        cell.isMarked = false
        exploredCells++
        if (cell.surroundingMines != 0) return
        exploreEmptyCellsRecursively(col - 1, row)
        exploreEmptyCellsRecursively(col + 1, row)
        exploreEmptyCellsRecursively(col, row - 1)
        exploreEmptyCellsRecursively(col, row + 1)
        exploreEmptyCellsRecursively(col - 1, row - 1)
        exploreEmptyCellsRecursively(col - 1, row + 1)
        exploreEmptyCellsRecursively(col + 1, row - 1)
        exploreEmptyCellsRecursively(col + 1, row + 1)
    }

    private fun mark(col: Int, row: Int): Boolean {
        val cell = mineField[row][col]
        if (cell.isExplored) return false
        cell.isMarked = !cell.isMarked
        if (cell.isMine) {
            if (cell.isMarked) correctMarks++
            else correctMarks--
        } else {
            if (cell.isMarked) wrongMarks++
            else wrongMarks--
        }
        return true
    }

    data class GameMove(
        val row: Int,
        val col: Int,
        val command: Type,
    ) {
        enum class Type {
            MARK, EXPLORE
        }
    }

}