
interface PlayersModeFactory {
    fun createPlayers(board: Board): List<Player>
}

open class InputPlayersModes(): PlayersModeFactory {
    override fun createPlayers(board: Board): List<Player> {
        val MESSAGE = "Choose the players mode: (0) Player vs Player (1) AI vs AI (2) Player vs AI"
        var playersMode = InputUtils.readIntWithCheck(MESSAGE, 0, 2)
        return when(playersMode){
            0   -> PlayerVsPlayer().createPlayers(board)
            1   -> AiVsAi().createPlayers(board)
            2   -> PlayerVsAi().createPlayers(board)
            else    ->  throw Error("Not reached.")
        }
    }
}

open class PlayerVsPlayer: PlayersModeFactory{
    override fun createPlayers(board: Board): List<Player> {
        val player1 = HumanPlayer(InputUtils.readLineWithMessage("Input P1's name: ")?: "P1", Team.CIRCLE)
        val player2 = HumanPlayer(InputUtils.readLineWithMessage("Input P2's name: ")?: "P2", Team.CROSS)
        return listOf(player1, player2)
    }
}

open class AiVsAi: PlayersModeFactory{
    override fun createPlayers(board: Board): List<Player> {
        val ai1 = StupidAiPlayer("AI1", Team.CIRCLE, board)
        val ai2 = StupidAiPlayer("AI2", Team.CROSS, board)
        return listOf(ai1, ai2)
    }
}

open class PlayerVsAi: PlayersModeFactory {
    override fun createPlayers(board: Board): List<Player> {
        val player = HumanPlayer(InputUtils.readLineWithMessage("Input Player's name: ")?: "Player", Team.CIRCLE)
        val ai = StupidAiPlayer("AI", Team.CROSS, board)
        return listOf(player, ai)
    }
}
