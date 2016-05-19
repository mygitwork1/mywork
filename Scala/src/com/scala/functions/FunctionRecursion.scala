package com.scala.functions

import scala.math.BigInt.int2bigInt

object FunctionRecursion {
  def main(args: Array[String]): Unit = {
    for(i<- 1 to 10){
      println("Factorial of:"+i+"="+factorial(i))
    }
  }
  def factorial(num:BigInt):BigInt={
    if(num<=1)
      1
    else
      num*factorial(num-1)
  }
}