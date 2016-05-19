package com.scala.classandobjects

class Point(val xc:Int, val yc:Int) {
  var x = xc
  var y = yc
  
  def move(dc:Int,dd:Int){
    x = x+dc
    y = y+dd
    println("Point x location::"+x)
    println("Point y location::"+y)
  }
  
  /*def main(args: Array[String]): Unit = {
    val point = new Point(10,20)
    point.move(10,10)
  }*/
}