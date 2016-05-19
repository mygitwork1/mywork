package com.scala.collections

object SetCollection {
  def main(args: Array[String]): Unit = {
    // Define a Set
    var set = Set(1,2,3,4,5,6,7,8,9)
    
    set.foreach { println}
    
    for(x<- set){
      print(x)
    }
    println()
    val ite = set.iterator
    while(ite.hasNext){
      print(ite.next())
    }
  }
}