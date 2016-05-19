package com.scala

object ConvertingArrayToString {
  
  def main(args: Array[String]): Unit = {
    val args = Array("Hello", "world", "it's", "me")
    println("args::"+args.foreach { println })
    val string = args.mkString(" ")
    println(string)
  }
}