package finalproject.util

import java.io.BufferedReader
import java.io.FileReader
import java.util.Scanner

class Point(x:Double, y:Double) {
    var x = x
    var y = y
}

class Equation(yIntercept:Double, slope:Double) {
    val yIntercept:Double = yIntercept
    val slope:Double = slope
    operator fun compareTo(other:Equation):Int {
        return if(other.slope > slope) -1 else if(other.slope < slope) 1 else
            if(other.yIntercept > yIntercept) -1 else if(other.yIntercept < yIntercept) 1 else 0
    }
}

object PointClient {

    const val validInputs:String = "1234567890(), "
    const val numbers:String = "1234567890"

    fun run():MutableList<Point> {
        println("Input points, (parenthesis to divide points, comma to distinguish b/w x and y")
        val src = Scanner(System.`in`);
        val input = src.nextLine().replace("\\s".toRegex(), "")
        val verifyInput = verifyInput(input)
        if(!verifyInput.first) throw IllegalArgumentException(verifyInput.second)
        return returnPoints(input)
    }

    private fun verifyInput(userInput:String):Pair<Boolean, String> {
        var openParen = 0
        var prev:Char = ' '
        for(i in userInput) {
            if(!(i in validInputs)) return Pair(false, "invalid char")
            if(i == '(') openParen++
            if(i == ')') openParen--
            if(prev == ',' && !(i in numbers)) return Pair(false, "misplaced comma")
            prev = i
        }
        if(openParen != 0) return Pair(false, "unequal parenthesis")
        return Pair(true, "it works")
    }

    private fun returnPoints(userInput:String):MutableList<Point> {
        val splitUserInput = userInput.split("(", ")", ",")
        val ans = mutableListOf<Point>()
        var prev = ""
        for(i in splitUserInput) {
            if(prev != "") {
                ans.add(Point(i.toDouble(), prev.toDouble()))
            }
        }
        return ans
    }

    fun readCsv(file:String):MutableList<Point> {
        if(file.substring(file.length - 4) != ".csv") throw IllegalArgumentException("Only Accept csv files")
        val fileReader = BufferedReader(FileReader(file))
        var line:String? = ""
        val ans = mutableListOf<Point>()
        while(line != null) {
            line = fileReader.readLine()
            if (verifyInput(line).first) {
                var prev = ""
                for(i in line.split(",")) {
                    if(prev != "") {
                        ans.add(Point(i.toDouble(), prev.toDouble()))
                    }
                }
            }
        }
        return ans
    }
}
