package PokerProblem

object Problem {
    fun solve(players: List<Player>): List<Player> {
        val pots = createAllPots(players)
        distributeStackToEachPlayers(players, pots)
        resetPlayers(players)
        return players
    }

    private fun distributeStackToEachPlayers(
        players: List<Player>,
        pots: List<Pot>
    ) {
        pots.forEach { pot ->
            val winners = getWinnersForOnePot(pot.players)
            winners.forEach { winner ->
                players.find { it.id == winner.id }?.let { it.stack += (pot.stack / winners.size) }
            }
        }
    }

    private fun getBestHand(players: List<Player>): Int {
        return players.filter {
            it.statePlayer != StatePlayer.FOLDED && it.statePlayer != StatePlayer.ELIMINATED
        }.minBy { it.handCurrentTurn }?.handCurrentTurn!!
    }

    private fun createAllPots(players: List<Player>): List<Pot> {
        var potentialWinners = players.filter {
            it.statePlayer != StatePlayer.FOLDED && it.statePlayer != StatePlayer.ELIMINATED
        }.toMutableList()
        val pots = mutableListOf<Pot>()
        if (potentialWinners.size > 1) {
            while (!isAllPotCreated(potentialWinners)) {
                val minStackBet =
                    potentialWinners.minBy { it.stackBetCurrentTurn }?.stackBetCurrentTurn
                minStackBet?.let { min ->
                    var stackPot = 0
                    potentialWinners.forEach {
                        if (it.stackBetCurrentTurn < min) {
                            stackPot += it.stackBetCurrentTurn
                            it.stackBetCurrentTurn = 0
                        } else {
                            stackPot += min
                            it.stackBetCurrentTurn -= min
                        }
                    }
                    pots.add(Pot(stackPot, potentialWinners))
                }
                potentialWinners =
                    potentialWinners.filter { it.stackBetCurrentTurn > 0 }.toMutableList()
            }
        } else {
            val stackPot = players.sumBy { it.stackBetCurrentTurn }
            pots.add(Pot(stackPot, potentialWinners))
        }
        return pots
    }

    private fun getWinnersForOnePot(players: List<Player>): List<Player> {
        return players.filter {
            it.statePlayer != StatePlayer.FOLDED && it.statePlayer != StatePlayer.ELIMINATED
        }.filter { it.handCurrentTurn == getBestHand(players) }
    }

    private fun isAllPotCreated(potentialWinners: List<Player>): Boolean {
        return potentialWinners.filter { it.stackBetCurrentTurn != 0 }.size <= 1
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