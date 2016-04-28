package com.scala.classandobjects

object TestObject1 {
  def main(args: Array[String]): Unit = {
    val ex = new ExtendingClass(10,20,30)
    ex.move(10, 10, 10)
  }
}