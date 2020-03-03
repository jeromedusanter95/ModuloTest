package PokerProblem

/**
 * data class Pot
 *
 * @param stack Int Stack represents the amount of dollar in the pot
 * @param players List<Player> represent the list of the player who can win the pot.
 * A folded player or eliminated player can't never be in that list !!
 */

data class Pot(
    var stack: Int,
    var players: List<Player>
)