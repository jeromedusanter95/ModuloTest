package PokerProblem

/**
 * data class Player
 *
 * @param id Int Id of the user (player1 is id = 1, player2 is id = 2...etc)
 * @param stack Int Stack represents the amount of dollar the player has.
 * CAREFUL in input the stack + stackBetCurrentTurn = stack at the beginning of the turn.
 * So the stack is actually the current stack that the player still has. when he bet some of his stack, it's no longer belong to him
 * @param stackBetCurrentTurn Int stack bet during the turn (you can picture that as the sum of the money bet during pre_flop, flop, turn and river)
 * @param handCurrentTurn Int player hand power. the best hand go to 1 (the best hand possible) to n players.
 * If there is an equality, they have the same hand power. The next player take the next number
 * Example : player1 has 1 and player4 has 1. the next best hand is 2.
 * @param state State represent the actual state of the player (folded, playing, all_in or eliminated)
 */

data class Player(
    var id: Int,
    var stack: Int,
    var stackBetCurrentTurn: Int,
    var handCurrentTurn: Int,
    var state: State
)