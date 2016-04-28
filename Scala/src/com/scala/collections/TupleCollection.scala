package com.scala.collections

object TupleCollection {
  def main(args: Array[String]): Unit = {
    // define a tuple
    var tuple = (1,"one")
    // Accessing values in the tuple
    println(tuple._1)
    println(tuple._2)
    
    var tuple1 = (1,2,3.2,"tuple1")
    
    println(tuple1._3)
    println(tuple1._4)
  }
}