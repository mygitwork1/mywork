package com.scala.strings

object CreatingString {
  def main(args: Array[String]): Unit = {
    // Declaring string
    val string:String = "Welcome to scala!!"
    
    //Alternate way to declare string
    val str = "Welcome to scala!!!"
    println(string.concat("String concated"))
    println(str)
  }
}