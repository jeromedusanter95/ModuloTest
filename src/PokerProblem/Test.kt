package PokerProblem

import org.junit.Test
import kotlin.test.assertEquals

// TODO CAREFUL DO NOT TOUCH THE TEST AT ANY POINTS !!!
class Test {
    // Test hands between players
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

    // Test player folded
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

    // Test equality between players
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

    //Test state_player Eliminated and All_in
    // Two players have each 100 dollars when the turn starts. They all bet 100 dollars so they are ALL_IN. First player won. Second Player is Eliminated
    @Test
    fun test4() {
        val inputs = listOf(
            Player(
                id = 0,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.ALL_IN
            ),
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 2,
                statePlayer = StatePlayer.ALL_IN
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

    // Test distribution of stack with one side pot
    // Three players have respectively 100, 200, 300 dollars when the turn starts. first player all_in, they call. Then player 2 bet 50 dollars and player 3 call.
    // First player has the best hand then player 3 then player 2
    @Test
    fun test5() {
        val inputs = listOf(
            Player(
                id = 0,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                statePlayer = StatePlayer.ALL_IN
            ),
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 150,
                handCurrentTurn = 3,
                statePlayer = StatePlayer.PLAYING
            ),
            Player(
                id = 2,
                stack = 150,
                stackBetCurrentTurn = 150,
                handCurrentTurn = 2,
                statePlayer = StatePlayer.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 0,
                stack = 300,
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
                stack = 250,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                statePlayer = StatePlayer.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

}