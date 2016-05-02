package com.scala.collections

object MapCollection {
  def main(args: Array[String]): Unit = {
    // Define a map
    
    var map = Map("one"->1,"two"->2,"three"->3)
    
    var one =map.get("one").get
    println(one)
    
    var keys =map.keysIterator
    while(keys.hasNext){
      val value = map.get(keys.next()).get
      println(value)
    }
    
  }
}