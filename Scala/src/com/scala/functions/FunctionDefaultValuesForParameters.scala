package com.scala.functions

object FunctionDefaultValuesForParameters {
  def main(args: Array[String]): Unit = {
    println("Addition::"+addInt())
  }
  def addInt(a:Int=5,b:Int=3):Int={
    var c = 0
    c = a+b
    return c
  }
}