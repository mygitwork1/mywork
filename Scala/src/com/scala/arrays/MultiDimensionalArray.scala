package com.scala.arrays

import Array._
object MultiDimensionalArray {
  def main(args: Array[String]): Unit = {
    val matrix = ofDim[Int](3,3)
    
    // constructing matrix
    for(i<- 0 to 2){
      for(j<- 0 to 2){
       
        matrix(i)(j)=j
        
      }
    }
    
   /* val matrix2 = ofDim[Int](4,4)
    for(i<- 0 to 3){
      for(j<- 0 to 3){
        for(k<- 0 to 3){
          matrix2(i)(j)(k) = k
        }
      }
        
    }*/
    
    // Printing matrix
    
    for(i<- 0 to 2){
      for(j<- 0 to 2){
         print(" "+ matrix(i)(j))
        
      }
      println()
    }
    
   // println(mArray)
  }
}