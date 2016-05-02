package com.scala.strings

object StringBuilder {
  def main(args: Array[String]): Unit = {
    var stringBuilder = new StringBuilder
    println(stringBuilder.append("welcome to string builder!!"))
    stringBuilder.append("String appended")
    println(stringBuilder)
  }
}