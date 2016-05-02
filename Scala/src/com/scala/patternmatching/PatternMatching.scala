package com.scala.patternmatching

object PatternMatching {
  def main(args: Array[String]): Unit = {
    println(matchTest(3))
  }
  def matchTest(x :Int):String= x match{
    case 1 =>"One"
    case 2 =>"Two"
    case _  =>"Many"
  }
}