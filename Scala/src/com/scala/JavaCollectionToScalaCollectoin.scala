package com.scala

object JavaCollectionToScalaCollectoin {
  def main(args: Array[String]): Unit = {
    var list = new java.util.ArrayList[Int]()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    import scala.collection.JavaConversions._
    list.foreach(i=>println(i))
  }
}