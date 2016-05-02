package com.scala.arrays

object DeclaringArray {
  def main(args: Array[String]): Unit = {
    
    //Defining an array
    
    var array:Array[String] = new Array[String](3)
    
    //      or
    
    var array1 = new Array[String](3)
    
    //      or
    
    var arrayInt = new Array[Int](3)
    
    //      or
    
    var array2 = Array("aadhya","neelima","subbu")
    
    // Inserting values into array 
    array(0)= "subbu"
    array (1) = "Neelima"
    
    arrayInt(0) = 1
    arrayInt(1) = 2
    arrayInt(2) = 3
  }
}