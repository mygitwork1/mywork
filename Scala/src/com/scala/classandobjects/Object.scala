package com.scala.classandobjects

object Object {
  def main(args: Array[String]): Unit = {
    val point = new Point(10,20)
    printPoint
    def printPoint{
      println("Point x location x::"+point.x)
      println("Point y location y::"+point.y)
    }
  }
}