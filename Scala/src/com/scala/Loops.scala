package com.scala

object Loops {
  def main(args: Array[String]): Unit = {
    var x = 20
    var numberList = List(1,2,3,4,5,6,7,8,9)
    // An infinite loop.
   /* while(x>10){
      println("X value is::"+x)
    }*/
    for(num<- numberList){
      println(num)
    }
    numberList.foreach { println }
  }
}