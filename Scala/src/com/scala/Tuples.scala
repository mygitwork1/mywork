package com.scala

object Tuples {
  def main(args: Array[String]): Unit = {
    val tup = (1,2)
    println(tup)
    val tup1 =(1,"subbu","bandi")
    println(tup1._1)
    println(tup1._2)
    val tup2 = tup1
    println("tup2:::"+tup2)
    
    tup2.productIterator.foreach {println}
    
    //val p = <person><name>{name}</name><age>{age}</age></person>
  }
}