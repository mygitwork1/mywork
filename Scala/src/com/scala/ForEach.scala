package com.scala

object ForEach {
  def main(args: Array[String]): Unit = {
    val sum = 0
    val list = List(1,2,3,4,5,6);
    //list.foreach(i=> i%2==0)
    for(i<-list if i%2==0)println(i)
   // println(sum)
    
    val names = Vector("subbu","neelima","aadhya","test","test1")
    for(name<-names)println(name)// Printing values in the vector
    
    for(name<-names if name.startsWith("t"))println(name)// printing names based on if condition
  }
}