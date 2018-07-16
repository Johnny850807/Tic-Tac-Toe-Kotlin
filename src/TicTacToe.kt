

open class TicTacToe(private var playersModes: PlayersModeFactory = InputPlayersModes()){
    var turn = -1
    var players: List<Player>? = null
    var gameBoard: Board? = null

    fun startGame(){
        initGameElements()
        val winnerTeam = runGameLoop()
        showWinnerResult(winnerTeam)
    }

    private fun initGameElements() {
        println("Game is initializing.")
        gameBoard = Board()
        players = playersModes.createPlayers(gameBoard!!)
    }

    private fun runGameLoop(): Team{
        println("Game started !!")
        var winnerTeam = Team.NONE

        do {
            println(gameBoard)
            executeNextPlayerChoiceOnBoard()
            winnerTeam = gameBoard?.detectWinnerTeam()!!
        }while (winnerTeam == Team.NONE
                && !gameBoard?.isFullOfTeams()!!)

        return winnerTeam
    }

    private fun executeNextPlayerChoiceOnBoard(){
        turn = (turn+1) % 2 //turn over
        val player = players!![turn]
        println("It's ${player.name}'s turn.")
        val position = player.choosePosition()
        gameBoard?.setTeam(position, player.team)
        println("${player.name} choose the position of $position.")
    }

    private fun showWinnerResult(winnerTeam:Team) {
        val p1 = players?.get(0)
        val p2 = players?.get(1)
        var winner: Player? = null
        if (p1?.team == winnerTeam)
            winner = p1
        else if (p2?.team == winnerTeam)
            winner = p2

        println(gameBoard)
        print ("${winner?.name?:"Nobody"} wins.")
    }


}