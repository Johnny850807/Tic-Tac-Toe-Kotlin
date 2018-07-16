import java.util.*

open class InputUtils{
    companion object {

        fun readIntWithCheck(message:String, min:Int, max:Int) : Int{
            val input = Scanner(System.`in`)
            var num: Int = 0
            do{
                println(message)
                num = input.nextInt()
            }while (num !in min..max)
            return num
        }

        fun readLineWithMessage(message: String) : String?{
            println(message)
            return readLine()
        }
    }
}
