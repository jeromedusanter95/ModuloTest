package spiralmatrix

import org.junit.Test
import kotlin.test.assertEquals

class Test {

    /**
     * Matrix 3 * 3
     * --------> Y
     * | A B C
     * | D E F
     * | G H I
     * |
     * X
     * First position is E, so firstPosX = 1, firstPosY = 1 ( E = matrix[1][1])
     * linesNumber = 3 columnsNumber = 3
     * Answer should be : EDGHIFCBA
     **/

    @Test
    fun test1() {
        val linesNumber = 3
        val columnsNumber = 3
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
        val answer = Problem.solve(1, 1, linesNumber, columnsNumber, matrix)
        assertEquals("EDGHIFCBA", answer)
    }

    /**
     * Matrix 3 * 3
     * --------> Y
     * | A B C
     * | D E F
     * | G H I
     * |
     * X
     * First position is B, so firstPosX = 0, firstPosY = 1 ( B = matrix[0][1])
     * linesNumber = 3 columnsNumber = 3
     * Answer should be : BADGHIFC
     **/

    @Test
    fun test2() {
        val linesNumber = 3
        val columnsNumber = 3
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
        val answer = Problem.solve(0, 1, linesNumber, columnsNumber, matrix)
        assertEquals("BADGHIFC", answer)
    }

    /**
     * Matrix 3 * 3
     * --------> Y
     * | A B C
     * | D E F
     * | G H I
     * |
     * X
     * First position is I, so firstPosX = 3, firstPosY = 3 ( I = matrix[3][3])
     * linesNumber = 3 columnsNumber = 3
     * Answer should be : IHGDABCFE
     **/

    @Test
    fun test3() {
        val linesNumber = 3
        val columnsNumber = 3
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
        val answer = Problem.solve(2, 2, linesNumber, columnsNumber, matrix)
        assertEquals("IHGDABCFE", answer)
    }
}