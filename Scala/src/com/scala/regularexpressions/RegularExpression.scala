package com.scala.regularexpressions
import scala.util.matching.Regex

object RegularExpression {
  def main(args: Array[String]): Unit = {
    val reg = "Scala".r
    val str = "Scala is good and cool language"
    println(reg findFirstIn str)
    
    val pattern = new Regex("(S|s)cala")
    val str1    = "Scala is scalable and cool"
    println(pattern findFirstIn str1)
    
    // Replacing matching text
    
    val patt  = "(S|s)cala".r
    val str2    = "Scala is scalable and cool"
    
    println(patt replaceFirstIn(str2,"Java"))
    
  }
}