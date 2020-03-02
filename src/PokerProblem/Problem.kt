package PokerProblem

object Problem {

    fun solve(players: List<Player>): List<Player> {
        val pot = Pot(0, 0)
        pot.apply {
            stack += players.sumBy { it.stackBetCurrentTurn }
        }
        val player = players.minBy { it.handCurrentTurn }
        player?.let {
            it.stack += pot.stack
        }
        resetPlayers(players)
        return players
    }

    private fun resetPlayers(players: List<Player>) {
        players.forEach { player ->
            player.apply {
                statePlayer = if (this.stack == 0) StatePlayer.ELIMINATED else StatePlayer.PLAYING
                stackBetCurrentTurn = 0
                handCurrentTurn = -1
            }
        }
    }
}