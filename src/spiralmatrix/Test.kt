package spiralmatrix

import org.junit.Test
import kotlin.test.assertEquals

class Test {

    private fun initializeMatrix(linesNumber: Int, columnsNumber: Int): Array<Array<Char>> {
        val matrix = Array(linesNumber) { Array(columnsNumber) { 'A' } }
        matrix[0][0] = 'A'
        matrix[0][1] = 'B'
        matrix[0][2] = 'C'
        matrix[1][0] = 'D'
        matrix[1][1] = 'E'
        matrix[1][2] = 'F'
        matrix[2][0] = 'G'
        matrix[2][1] = 'H'
        matrix[2][2] = 'I'
        return matrix
    }

    /**
     * Matrix 3 * 3
     * --------> Y
     * | A B C
     * | D E F
     * | G H I
     * |
     * X
     **/

    /**
     * firstPosition -> Answer
     *  A -> ADGHIFCBE
     *  B -> BADGHIFC
     *  C -> CBADGHIFE
     *  D -> DGHIFCBA
     *  E -> EDGHIFCBA
     *  F -> FEDGHI
     *  G -> GHIFCBADE
     *  H -> HIFCBADG
     *  I -> IHGDABCFE
     **/


    /**
     * First position is : A
     * Answer should be : ADGHIFCBE
     **/

    @Test
    fun test1() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 0
        val firstPosY = 0
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("ADGHIFCBE", answer)
    }

    /**
     * First position is : B
     * Answer should be : BADGHIFC
     **/

    @Test
    fun test2() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 0
        val firstPosY = 1
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("BADGHIFC", answer)
    }

    /**
     * First position is : C
     * Answer should be : CBADGHIFE
     **/

    @Test
    fun test3() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 0
        val firstPosY = 2
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("CBADGHIFE", answer)
    }

    /**
     * First position is : D
     * Answer should be : DGHIFCBA
     **/

    @Test
    fun test4() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 1
        val firstPosY = 0
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("DGHIFCBA", answer)
    }

    /**
     * First position is : E
     * Answer should be : EDGHIFCBA
     **/

    @Test
    fun test5() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 1
        val firstPosY = 1
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("EDGHIFCBA", answer)
    }

    /**
     * First position is : F
     * Answer should be : FEDGHI
     **/

    @Test
    fun test6() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 1
        val firstPosY = 2
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("FEDGHI", answer)
    }

    /**
     * First position is : G
     * Answer should be : GHIFCBADE
     **/

    @Test
    fun test7() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 2
        val firstPosY = 0
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("GHIFCBADE", answer)
    }

    /**
     * First position is : H
     * Answer should be : HGDABCFI
     **/

    @Test
    fun test8() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 2
        val firstPosY = 1
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("HGDABCFI", answer)
    }

    /**
     * First position is : I
     * Answer should be : IHGDABCFE
     **/

    @Test
    fun test9() {
        val linesNumber = 3
        val columnsNumber = 3
        val firstPosX = 2
        val firstPosY = 2
        val matrix = initializeMatrix(linesNumber, columnsNumber)
        val answer = Problem.solve(firstPosX, firstPosY, linesNumber, columnsNumber, matrix)
        assertEquals("IHGDABCFE", answer)
    }
}