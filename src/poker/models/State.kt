package poker.models

/**
 * enum class State
 *
 * @property PLAYING when a player is still in course for the game and the turn
 * @property ELIMINATED when a player lost the game by losing all his stack
 * @property FOLDED when a player fold himself. Folded players can't win any money at this turn so they automatically lost the money they bet.
 * @property ALL_IN when a player bet all the money he has.
 */

enum class State {
    PLAYING, FOLDED, ALL_IN, ELIMINATED
}