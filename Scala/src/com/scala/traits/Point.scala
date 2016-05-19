package com.scala.traits

class Point(val xc:Int,yc:Int) extends Equal {
  var x:Int = xc
  var y:Int = yc
  def isEqual(obj:Any)=
    obj.isInstanceOf[Point] &&
    obj.asInstanceOf[Point].x == x
}