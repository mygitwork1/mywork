package com.scala

object Map {
  def main(args: Array[String]): Unit = {
    val myFriends = List("Adam", "David", "Frank")
    val adamsFriends = List("Nick K", "Bill M")
    val davidsFriends = List("Becca G", "Kenny D", "Bill M")
    val friendsOffriends = List(adamsFriends,davidsFriends)
    
    val seq  = Seq("apple","orange","grape")
    val map = myFriends.map(_.toUpperCase())
    val sqMap = seq.map(_.toUpperCase())
    println(map)
    println(sqMap)
  }
}