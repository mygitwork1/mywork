package com.scala.functions

object CurryingFunction {
  def main(args: Array[String]): Unit = {
    var str1 = "hello"
    var str2 = "welcome"
    println(strcat(str1)(str2))
    println(strcat1(str1)(str2))
  }
  def strcat1 (str1:String)=(str2:String)=> str1+str2
  def strcat(str1:String)(str2:String)={
    str1+str2
  }
}