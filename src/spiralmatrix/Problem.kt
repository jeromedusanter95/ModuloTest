package spiralmatrix

object Problem {

    /**
     * Write an algorithm which allows to traverse a 2d matrix in the form of a spiral
     * Rules :
     * You should always goes into the same direction as the previous one if you can
     * If you can't, you should take another direction with that order of preferences :
     * Left, Down, Right, and Up (meaning if you can go either left or down, you have to go left)
     * You can't pass on a position if you already pass on it
     **/

    var currentDirection = Direction.LEFT
    var answer = ""
    var currentPosX = 0
    var currentPosY = 0
    lateinit var secondMatrix: Array<Array<Int>>

    fun solve(
        firstPosX: Int,
        firstPosY: Int,
        linesNumber: Int,
        columnsNumber: Int,
        matrix: Array<Array<Char>>
    ): String {

        currentDirection = Direction.LEFT
        currentPosX = firstPosX
        currentPosY = firstPosY
        secondMatrix = Array(linesNumber) { Array(columnsNumber) { 0 } }
        secondMatrix[currentPosX][currentPosY] = 1
        answer = ""
        answer += matrix[currentPosX][currentPosY]

        while (!isSpiralOver(linesNumber, columnsNumber)) {
            if (!shouldContinueInSameDirection(linesNumber, columnsNumber)) {
                currentDirection = getNextDirection(linesNumber, columnsNumber)
            }
            movingToNextDirection(matrix)
        }
        return answer
    }

    private fun isSpiralOver(linesNumber: Int, columnsNumber: Int): Boolean {
        return if (currentPosY - 1 >= 0 && secondMatrix[currentPosX][currentPosY - 1] == 0) {
            false
        } else if (currentPosY + 1 < columnsNumber && secondMatrix[currentPosX][currentPosY + 1] == 0) {
            false
        } else if (currentPosX - 1 >= 0 && secondMatrix[currentPosX - 1][currentPosY] == 0) {
            false
        } else !(currentPosX + 1 < linesNumber && secondMatrix[currentPosX + 1][currentPosY] == 0)
    }

    private fun shouldContinueInSameDirection(linesNumber: Int, columnsNumber: Int): Boolean {
        return when (currentDirection) {
            Direction.LEFT -> {
                currentPosY - 1 >= 0 && secondMatrix[currentPosX][currentPosY - 1] == 0
            }
            Direction.DOWN -> {
                currentPosX + 1 < linesNumber && secondMatrix[currentPosX + 1][currentPosY] == 0
            }
            Direction.RIGHT -> {
                currentPosY + 1 < columnsNumber && secondMatrix[currentPosX][currentPosY + 1] == 0
            }
            Direction.UP -> {
                currentPosX - 1 >= 0 && secondMatrix[currentPosX - 1][currentPosY] == 0
            }
        }
    }

    private fun movingToNextDirection(matrix: Array<Array<Char>>) {
        when (currentDirection) {
            Direction.LEFT -> {
                currentPosY--
                answer += matrix[currentPosX][currentPosY]
                secondMatrix[currentPosX][currentPosY] = 1
            }
            Direction.DOWN -> {
                currentPosX++
                answer += matrix[currentPosX][currentPosY]
                secondMatrix[currentPosX][currentPosY] = 1
            }
            Direction.RIGHT -> {
                currentPosY++
                answer += matrix[currentPosX][currentPosY]
                secondMatrix[currentPosX][currentPosY] = 1
            }
            Direction.UP -> {
                currentPosX--
                answer += matrix[currentPosX][currentPosY]
                secondMatrix[currentPosX][currentPosY] = 1
            }
        }
    }

    private fun getNextDirection(linesNumber: Int, columnsNumber: Int): Direction {
        return if (currentPosY - 1 >= 0 && secondMatrix[currentPosX][currentPosY - 1] == 0) {
            Direction.LEFT
        } else if (currentPosX + 1 < linesNumber && secondMatrix[currentPosX + 1][currentPosY] == 0) {
            Direction.DOWN
        } else if (currentPosY + 1 < columnsNumber && secondMatrix[currentPosX][currentPosY + 1] == 0) {
            Direction.RIGHT
        } else
            Direction.UP
    }

    enum class Direction {
        LEFT, DOWN, RIGHT, UP
    }
}