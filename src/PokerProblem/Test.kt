package PokerProblem

import org.junit.Test
import kotlin.test.assertEquals

// TODO CAREFUL DO NOT TOUCH THE TEST AT ANY POINTS !!!
class Test {
    // First Test
    // Two players have each 100 dollars when the turn start. They both bet 50 dollars and they compare their cards at the end
    @Test
    fun test1() {
        val inputs = listOf(
            Player(
                id = 0,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 2,
                statePlayer = StatePlayer.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 0,
                stack = 150,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }
}