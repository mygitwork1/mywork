package com.scala.collections

object ListCollection {
  def main(args: Array[String]): Unit = {
    // Define List
    var list = List(1,2,3,4,5,6)
    list.foreach { println}
    
    for(i<- list){
      println(i)
    }
    
    val ite =list.iterator
    while(ite.hasNext){
      print(ite.next())
      
    }
  }
}