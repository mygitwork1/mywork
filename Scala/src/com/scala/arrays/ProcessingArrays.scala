package com.scala.arrays

object ProcessingArrays {
  def main(args: Array[String]): Unit = {
    var myList = Array(1,2,3,4,5,6,7,8,9)
    
    // Displaying values in the array
    for(i <- myList)
      println(i)
      
    // Counting values in the array
      
      var total = 0
      for(i <- 0 to (myList.length-1)){
        total += myList(i)
      }
      println("total::"+total)
      
      var max = myList(0)
      for(i <- 0 to (myList.length-1)){
        if(myList(i)>max) max= myList(i)
      }
      println("Max:::"+max)
  }
}