import java.util.*

abstract class Player(var name: String, var team: Team){
    abstract fun choosePosition() : Int
}

open class HumanPlayer(name: String, team: Team) : Player(name, team) {
    override fun choosePosition(): Int {
        return InputUtils.readIntWithCheck("Input your choose (0~8): ", 0, 8)
    }
}

/**
 * This AI is not smart, he is only able to guess randomly.
 */
open class StupidAiPlayer(name:String, team: Team, var board:Board) : Player(name, team) {
    val random = Random()
    override fun choosePosition(): Int {
        Thread.sleep(1000)  //delay
        val positions = board.getAvailablePositions()
        return positions[random.nextInt(positions.size)]
    }
}