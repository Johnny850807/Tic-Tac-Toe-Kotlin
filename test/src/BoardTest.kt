import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BoardTest {
    private var board = Board()

    @Before
    fun initBoard(){
        board = Board()
    }

    @Test
    fun testWinnerInTheRow1(){
        board = Board(arrayOf(arrayOf(Team.CIRCLE, Team.CIRCLE, Team.CIRCLE),
                            arrayOf(Team.NONE, Team.NONE, Team.NONE),
                            arrayOf(Team.NONE, Team.NONE, Team.NONE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheRow2(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.NONE, Team.NONE),
                arrayOf(Team.CIRCLE, Team.CIRCLE, Team.CIRCLE),
                arrayOf(Team.NONE, Team.NONE, Team.NONE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheRow3(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.NONE, Team.NONE),
                arrayOf(Team.NONE, Team.NONE, Team.NONE),
                arrayOf(Team.CIRCLE, Team.CIRCLE, Team.CIRCLE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheCol1(){
        board = Board(arrayOf(arrayOf(Team.CIRCLE, Team.NONE, Team.NONE),
                            arrayOf(Team.CIRCLE, Team.NONE, Team.NONE),
                            arrayOf(Team.CIRCLE, Team.NONE, Team.NONE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheCol2(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.CIRCLE, Team.NONE),
                            arrayOf(Team.NONE, Team.CIRCLE, Team.NONE),
                            arrayOf(Team.NONE, Team.CIRCLE, Team.NONE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheCol3(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.NONE, Team.CIRCLE),
                            arrayOf(Team.NONE, Team.NONE, Team.CIRCLE),
                            arrayOf(Team.NONE, Team.NONE, Team.CIRCLE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheDiagonalToRightDown(){
        board = Board(arrayOf(arrayOf(Team.CIRCLE, Team.NONE, Team.NONE),
                                arrayOf(Team.NONE, Team.CIRCLE, Team.NONE),
                                arrayOf(Team.NONE, Team.NONE, Team.CIRCLE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testWinnerInTheDiagonalToRightUp(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.NONE, Team.CIRCLE),
                                arrayOf(Team.NONE, Team.CIRCLE, Team.NONE),
                                arrayOf(Team.CIRCLE, Team.NONE, Team.NONE)))
        assertEquals(Team.CIRCLE, board.detectWinnerTeam())
    }

    @Test
    fun testNoWinner(){
        board = Board(arrayOf(arrayOf(Team.CROSS, Team.NONE, Team.NONE),
                            arrayOf(Team.NONE, Team.CROSS, Team.CIRCLE),
                            arrayOf(Team.CIRCLE, Team.NONE, Team.CIRCLE)))
        assertEquals(Team.NONE, board.detectWinnerTeam())
    }


    @Test
    fun testBoardIsFullOfTeams(){
        board = Board(arrayOf(arrayOf(Team.CIRCLE, Team.CROSS, Team.CROSS),
                                arrayOf(Team.CROSS, Team.CIRCLE, Team.CIRCLE),
                                arrayOf(Team.CIRCLE, Team.CIRCLE, Team.CROSS)))
        assertEquals(true, board.isFullOfTeams())
    }


    @Test
    fun testBoardIsNotFullOfTeams(){
        board = Board(arrayOf(arrayOf(Team.NONE, Team.NONE, Team.CIRCLE),
                arrayOf(Team.NONE, Team.NONE, Team.CIRCLE),
                arrayOf(Team.NONE, Team.NONE, Team.CIRCLE)))
        assertEquals(false, board.isFullOfTeams())
    }


}