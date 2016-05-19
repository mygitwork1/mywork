package com.scala.arrays
import Array._
object ConcatenateArrays {
  def main(args: Array[String]): Unit = {
    var array1 = Array(1,2,3,4,5)
    var array2 = Array(6,7,8,9,10)
    var array3 = concat(array1,array2)
    for(i<- array3){
    println(i)
    }
    }
}