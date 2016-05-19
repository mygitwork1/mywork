package com.scala

object NestedFunction {
  def main(args: Array[String]): Unit = {
    println(factorial(0))
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
  }
  def factorial(i:Int):Int={
    def fact(i:Int,accum:Int):Int={
      if(i<=1)
          accum
      else
        fact(i-1,i*accum)
    }
    fact(i,1)
  }
}