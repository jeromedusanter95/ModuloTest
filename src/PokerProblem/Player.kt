package PokerProblem

//TODO Write documentation

data class Player(
    var id: Int,
    var stack: Int,
    var stackBetCurrentTurn: Int,
    var handCurrentTurn: Int,
    var statePlayer: StatePlayer
)