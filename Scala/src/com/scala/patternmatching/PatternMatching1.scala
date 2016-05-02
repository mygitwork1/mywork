package com.scala.patternmatching

object PatternMatching1 {
  def main(args: Array[String]): Unit = {
    println(matchingTest(1))
    println(matchingTest(4))
    println(matchingTest("two"))
  }
  def matchingTest(x:Any):Any = x  match {
    case 1 => "One"
    case "two" => 2
    case _ => "Many"
    case y:Int => "scala.Int"
  }
}