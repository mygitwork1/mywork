package com.scala.arrays

import Array._
object CreatingArrayWithRange {
  def main(args: Array[String]): Unit = {
    var array1 = range(1, 10, 2)
    var array2 = range(10,20)
    
    for(x<- array1){
      print(" "+x)
    }
    println()
    for(x<- array2){
      print(" "+x)
    }
  }
}