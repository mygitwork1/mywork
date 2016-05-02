package com.scala

object Functions1 {
  def main(args: Array[String]): Unit = {
    add(2,3)
    println(add1(3,3))
  }
  // Function which is not returning any value
  def add(a:Int,b:Int):Unit={
    var c = a+b
    println(c)
  }
  //Function which returning a value
  def add1(a1:Int,b1:Int):Int={
    var c = a1+b1
    return c
  }
}