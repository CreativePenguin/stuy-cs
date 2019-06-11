package finalproject

import java.io.BufferedReader
import java.io.FileReader
import java.util.Scanner

class Point(x:Int, y:Int) {
  var x = x
  var y = y
}

object PointClient {
  
  const val validInputs:String = "1234567890(), "
  const val numbers:String = "1234567890"
  
  fun run():MutableList<Point> {
    println("Input points, (parenthesis to divide points, comma to distinguish b/w x and y")
    val src = Scanner(System.`in`);
    val input = src.nextLine().replace("\\s".toRegex(), "")
    if(!verifyInput(input)) throw IllegalArgumentException()
    return returnPoints(input)
  }
  
  private fun verifyInput(userInput:String):Boolean {
    var openParen = 0
    var prev:Char = ' '
    for(i in userInput) {
      if(!(i in validInputs)) return false
      if(i == '(') openParen++
      if(i == ')') openParen--
      if(prev == ',' && !(i in numbers)) return false
      prev = i
    }
    if(openParen != 0) return false
    return true
  }
  
  private fun returnPoints(userInput:String):MutableList<Point> {
    val splitUserInput = userInput.split("(", ")", ",")
    val ans = mutableListOf<Point>()
    var prev = ""
    for(i in splitUserInput) {
      if(prev != "") {
          ans.add(Point(i.toInt(), prev.toInt()))
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
      if (verifyInput(line)) {
        var prev = ""
        for(i in line.split(",")) {
          if(prev != "") {
            ans.add(Point(i.toInt(), prev.toInt()))
          }
        } 
      }
    }
    return ans
  }
}