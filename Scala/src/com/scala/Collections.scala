package com.scala
import scala.collection.mutable.ArrayBuffer

object Collections {
  def main(args: Array[String]): Unit = {
    
    // Defining an array with known elements
    val fruitsArray = Array("apple","orange","banana","grapes")
    
    // Defining an array with fixed size
    val fixedArray = new Array[String](3)
    fixedArray(0)="subbu"
    fixedArray(1)="aadhya"
    fixedArray(2)="neelima"
    println(fixedArray(0))
    
    // Mutable array
    var fruits = ArrayBuffer[String]()
    fruits+="apple"
    fruits+="Orange"
    fruits+="banana"
    fruits+="grapes"
    println(fruits)
    println(fruits(1))
    println(fruits.length)
    
  }
}