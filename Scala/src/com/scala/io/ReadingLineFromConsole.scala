package com.scala.io

object ReadingLineFromConsole {
  def main(args: Array[String]): Unit = {
    println("Please Enter your input::")
    val input = Console.readLine()
    println("Your input is::"+input)
  }
}