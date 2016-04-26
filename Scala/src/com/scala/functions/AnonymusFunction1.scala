package com.scala.functions

object AnonymusFunction1 {
  def main(args: Array[String]): Unit = {
    val inc = (x:Int)=>x+1
    //println(inc)
    var c = inc(4)-1
    println(c)
    
    var mul = (x:Int,y:Int) => x*y
    println(mul(2,3))
    
    var userDir = () => println{System.getProperty("user.dir")}
    println(userDir)
  
  }
}