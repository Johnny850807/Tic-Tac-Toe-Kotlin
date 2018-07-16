open class Board{
    val grids = Array(3, { row ->
        Array(3, { col ->
            Block(row*3 + col)
        })
    })

    constructor()

    constructor(teamGrids : Array<Array<Team>>){
        setTeams(teamGrids)
    }

    fun setTeams(teamGrids : Array<Array<Team>>){
        for (i in 0..2)
            for (j in 0..2)
                grids[i][j].team = teamGrids[i][j]
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        for (row in grids)
        {
            for (block in row)
                stringBuilder.append(block)
            stringBuilder.appendln()
        }
        return stringBuilder.toString()
    }

    fun setTeam(position:Int, team:Team){
        val row = position / 3
        val col = position % 3
        grids[row][col].team = team
    }

    fun detectWinnerTeam(): Team {
        val detectingTasks = arrayOf({detectWinnerTeamInEachRow()},
                                {detectWinnerTeamInEachColumn()},
                                {detectWinnerTeamInBothDiagonals()})

        return detectingTasks
                .map { it() }
                .firstOrNull { winnerTeam -> winnerTeam != Team.NONE }
                ?: Team.NONE  //nobody wins
    }

    private fun detectWinnerTeamInEachRow(): Team {
        for (i in 0..2)
            if (grids[i][0].team != Team.NONE &&
                    grids[i][0].team == grids[i][1].team && grids[i][1].team == grids[i][2].team)
                return grids[i][0].team
        return Team.NONE
    }

    private fun detectWinnerTeamInEachColumn(): Team {
        for (i in 0..2)
            if (grids[0][i].team != Team.NONE &&
                    grids[0][i].team == grids[1][i].team && grids[1][i].team == grids[2][i].team)
                return grids[0][i].team
        return Team.NONE
    }

    private fun detectWinnerTeamInBothDiagonals(): Team {
        if ( (grids[0][0].team == grids[1][1].team && grids[1][1].team == grids[2][2].team)
                || (grids[0][2].team == grids[1][1].team && grids[1][1].team == grids[2][0].team))
            return grids[1][1].team
        return Team.NONE
    }

    fun isFullOfTeams(): Boolean{
        var countEmptyBlock = 0
        for (row in grids)
            for (block in row)
                if (block.team == Team.NONE)
                    countEmptyBlock ++
        return countEmptyBlock == 0
    }

    fun getAvailablePositions(): List<Int>{
        val positions = mutableListOf<Int>()
        for (i in 0..2)
            for (j in 0..2)
                if (grids[i][j].team == Team.NONE)
                    positions.add(i*3+j)
        return positions
    }
}
