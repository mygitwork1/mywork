package com.scala
import scala.util.control._

object BreakStatement {
  def main(args: Array[String]): Unit = {
    var numList = List(1,2,3,4,5,6,7,8,9)
    var break = new Breaks
    break.breakable{
    for(num<- numList){
      println("Number::"+num)
      if(num == 7){
        break.break()
      }
    }
  }
  }
}