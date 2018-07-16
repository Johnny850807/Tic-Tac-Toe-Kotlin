enum class Team{
    CIRCLE, CROSS, NONE
}

open class Block (var number: Int, var team: Team = Team.NONE){


    override fun toString(): String {
        return when(team){
            Team.CIRCLE -> " O "
            Team.CROSS  -> " X "
            else    -> " $number "
        }
    }
}

