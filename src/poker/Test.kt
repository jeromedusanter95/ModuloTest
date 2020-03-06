package poker

import org.junit.Test
import poker.models.Player
import poker.models.State
import kotlin.test.assertEquals

/** CAREFUL DO NOT TOUCH THE TESTS !!!**/

class Test {

    /**
     * Test 1 : Test hands between players
     * two players have each 100 dollars when the turn starts.
     * They both bet 50 dollars and they compare their cards at the end
     */

    @Test
    fun test1() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 2,
                state = State.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 150,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 2 : Test with folded player
     * Two players have each 100 dollars when the turn starts.
     * They both bet 50 dollars. player2 is bluffing so player1 folds
     */

    @Test
    fun test2() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                state = State.FOLDED
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 2,
                state = State.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 150,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 3 : Test equality between players
     * Three players have each 100 dollars when the turn starts.
     * They all bet 50 dollars. player1 and player3 have the same hands. They split the main pot
     */

    @Test
    fun test3() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 2,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 50,
                stackBetCurrentTurn = 50,
                handCurrentTurn = 1,
                state = State.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 125,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 125,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )

        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 4 : Test state ELIMINATED and ALL_IN
     * Two players have each 100 dollars when the turn starts.
     * They all bet 100 dollars so they are both all-in.
     * Player1 win so player2 is eliminated
     */

    @Test
    fun test4() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 2,
                state = State.ALL_IN
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.ELIMINATED
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 5 : Test distribution of stack with one side pot
     * Three players have respectively 100, 200, 300 dollars when the turn starts.
     * Player1 all-in, the rest call. Then player2 bet 50 dollars and player3 calls.
     * Player1 has the best hand then player3 then player2
     */

    @Test
    fun test5() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 150,
                handCurrentTurn = 3,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 150,
                stackBetCurrentTurn = 150,
                handCurrentTurn = 2,
                state = State.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 300,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 50,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 250,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 6 : Test distribution of stack with several side pots
     * Five players have respectively 100, 200, 300, 400, 500 dollars when the turn starts.
     * Pre-flop : Player1 all-in, they all called
     * Flop : Player4 bet 200 dollars, player2 all_in, player3 folds, player5 calls
     * Turn : Player4 all-in player5 calls
     * Player1 has the best hand then player2 then player3...etc
     **/

    @Test
    fun test6() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 200,
                handCurrentTurn = 2,
                state = State.ALL_IN
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 3,
                state = State.FOLDED
            ),
            Player(
                id = 4,
                stack = 0,
                stackBetCurrentTurn = 400,
                handCurrentTurn = 4,
                state = State.ALL_IN
            ),
            Player(
                id = 5,
                stack = 100,
                stackBetCurrentTurn = 400,
                handCurrentTurn = 5,
                state = State.PLAYING
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 500,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 300,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 4,
                stack = 400,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 5,
                stack = 100,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 7 : Test if people get back so money if they bet more than the stack of the opponent
     * Two players have respectively 100 and 200 dollars when the turn starts.
     * Player2 all-in, player1 all-in
     */

    @Test
    fun test7() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 200,
                handCurrentTurn = 2,
                state = State.ALL_IN
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 100,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 8 : Test if people get back so money if they bet more than the stack of the opponent with several pots
     * Five players have respectively 100, 200, 300, 400, 500 dollars when the turn starts.
     * Pre flop : Player1 all-in, they all called
     * Flop : Player4 bet 200 dollars, player2 all-in, player3 folds, player5 calls
     * Turn : Player5 all-in Player4 all-in
     * Player1 has the best hand then player2 then player3...etc
     */

    @Test
    fun test8() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 200,
                handCurrentTurn = 2,
                state = State.ALL_IN
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 3,
                state = State.FOLDED
            ),
            Player(
                id = 4,
                stack = 0,
                stackBetCurrentTurn = 400,
                handCurrentTurn = 4,
                state = State.ALL_IN
            ),
            Player(
                id = 5,
                stack = 0,
                stackBetCurrentTurn = 500,
                handCurrentTurn = 5,
                state = State.ALL_IN
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 500,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 2,
                stack = 300,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 4,
                stack = 400,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 5,
                stack = 100,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }

    /**
     * Test 9 : Test everything together (several pots, equality, eliminated, money repaid...)
     * Five players have respectively 100, 200, 300, 400, 500 dollars when the turn starts.
     * Pre flop : Player1 all-in, the rest call.
     * Flop : Player4 bet 200 dollars, player 2 all-in, player3 folds, player5 calls.
     * Turn : Player5 all-in Player4 all-in.
     * Player2 and player5 has the best hand then player3 then player4 then player1.
     */

    @Test
    fun test9() {
        val inputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 4,
                state = State.ALL_IN
            ),
            Player(
                id = 2,
                stack = 0,
                stackBetCurrentTurn = 200,
                handCurrentTurn = 1,
                state = State.ALL_IN
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 100,
                handCurrentTurn = 2,
                state = State.FOLDED
            ),
            Player(
                id = 4,
                stack = 0,
                stackBetCurrentTurn = 400,
                handCurrentTurn = 3,
                state = State.ALL_IN
            ),
            Player(
                id = 5,
                stack = 0,
                stackBetCurrentTurn = 500,
                handCurrentTurn = 1,
                state = State.ALL_IN
            )
        )
        val outputs = listOf(
            Player(
                id = 1,
                stack = 0,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.ELIMINATED
            ),
            Player(
                id = 2,
                stack = 400,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 3,
                stack = 200,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            ),
            Player(
                id = 4,
                stack = 0,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.ELIMINATED
            ),
            Player(
                id = 5,
                stack = 900,
                stackBetCurrentTurn = 0,
                handCurrentTurn = -1,
                state = State.PLAYING
            )
        )
        assertEquals(outputs, Problem.solve(inputs))
    }
}