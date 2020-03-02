package PokerProblem

object Problem {
    fun solve(players: List<Player>): List<Player> {
        val mainPot = buildMainPot(players)
        distributeStackToEachPlayers(getWinners(players), mainPot)
        resetPlayers(players)
        return players
    }

    private fun distributeStackToEachPlayers(
        winners: List<Player>,
        mainPot: Pot
    ) {
        winners.forEach {
            it.stack += mainPot.stack / winners.size
        }
    }

    private fun getBestHand(players: List<Player>): Int {
        return players.filter {
            it.statePlayer != StatePlayer.FOLDED && it.statePlayer != StatePlayer.ELIMINATED
        }.minBy { it.handCurrentTurn }?.handCurrentTurn!!
    }

    private fun getWinners(players: List<Player>): List<Player> {
        return players.filter {
            it.statePlayer != StatePlayer.FOLDED && it.statePlayer != StatePlayer.ELIMINATED
        }.filter { it.handCurrentTurn == getBestHand(players) }
    }

    private fun buildMainPot(players: List<Player>): Pot {
        return Pot(0, players.sumBy { it.stackBetCurrentTurn })
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