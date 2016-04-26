package com.scala.functions

object FunctionWithNamedArguements {
  def main(args: Array[String]): Unit = {
    println(addInt(b=3,a=2))
  }
  
  def addInt(a:Int,b:Int):Int={
    return a+b
  }
}