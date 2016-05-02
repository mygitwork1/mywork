package com.scala

object Functions {
  def add(x:Int):Int=x+x;
  def mul1(a:Int,b:Int):Int = a*b
  def mul(a:Int,b:Int):Int={
    a*b
  }
 def main(args: Array[String]): Unit = {
  // val test = new Functions()
   println(add(3))
   println(mul(4,4))
   println(mul1(5,4))
 } 
}