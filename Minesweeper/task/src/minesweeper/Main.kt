package minesweeper

const val MINEFIELD_SIZE = 9

fun main() {
    print("How many mines do you want on the field? ")
    val numberOfMines = readLine()!!.toInt()
    val fieldSize = MINEFIELD_SIZE * MINEFIELD_SIZE
    if (numberOfMines < 0) {
        println("Invalid number of mines")
        return
    }
    if (numberOfMines > fieldSize) {
        println("$numberOfMines cannot be placed on a field of size $fieldSize")
        return
    }
    val minesweeper = Minesweeper(MINEFIELD_SIZE, numberOfMines)
    val requestNextMove = "Set/unset mine marks or claim a cell as free:"
    val gameWon = "Congratulations! You found all the mines!"
    val gameLost = "You stepped on a mine and failed!"

    do {
        minesweeper.printMinefield()
        try {
            do {
                println(requestNextMove)
                val move = getNextMove()
                val moveSucceeded = minesweeper.playMove(move)
            } while (!moveSucceeded)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    } while (!minesweeper.gameOver)

    minesweeper.printMinefield()
    if (minesweeper.won) {
        println(gameWon)
    } else {
        println(gameLost)
    }
}

private fun getNextMove(): Minesweeper.GameMove {
    val input = readLine()!!.split(" ")
    if (input.size != 3) {
        throw IllegalArgumentException("Incorrect number of items. Expected 3, received ${input.size}.")
    }

    val moveType = when (input[2]) {
        "mine" -> Minesweeper.GameMove.Type.MARK
        "free" -> Minesweeper.GameMove.Type.EXPLORE
        else -> throw IllegalArgumentException("Incorrect type of game move.")
    }

    return Minesweeper.GameMove(
        input[1].toInt(),
        input[0].toInt(),
        moveType
    )
}
