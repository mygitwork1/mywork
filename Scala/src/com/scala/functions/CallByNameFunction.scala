package com.scala.functions

object CallByNameFunction {
  def main(args: Array[String]): Unit = {
      delayed(time())
  }
  def time():Long={
    println("Getting time in nano seconds!!")
    System.nanoTime()
  }
  def delayed(t: => Long)={
    println("Getting delayed time!!!!")
    println("Param::"+t)
  }
}