package PokerProblem

import org.junit.Test
import kotlin.test.assertEquals

// TODO CAREFUL DO NOT TOUCH THE TEST AT ANY POINTS !!!
class Test {
    // Two players have each 100 dollars when the turn starts. They both bet 50 dollars and they compare their cards at the end
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

    // Two players have each 100 dollars when the turn starts. They both bet 50 dollars. Second player bluff and first player fold
    @Test
    fun test2() {
        val inputs = listOf(
            Player(
                id = 0,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.FOLDED
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
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 1,
                stack = 150,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    // Three players have each 100 dollars when the turn starts. They all bet 50 dollars. First player and third player have the same hands. They split the main pot
    @Test
    fun test3() {
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
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 0,
                stack = 125,
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
            ),
            Player(
                id = 2,
                stack = 125,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            )

        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    // Two players have each 100 dollars when the turn starts. They all bet 100 dollars. First player won. Second Player is Eliminated
    @Test
    fun test4() {
        val inputs = listOf(
            Player(
                id = 0,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 2,
                statePlayer = StatePlayer.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 0,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.ELIMINATED
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

}