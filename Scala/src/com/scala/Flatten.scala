package com.scala

import scala.collection.mutable.ArrayBuffer

object Flatten {
  def main(args: Array[String]): Unit = {
    // Flatten on List
    val list1 = List(List(1,2,3,4,5),List(6,7,8,9,10))
   // val list2 = List(6,7,8,9,10)
    val fl1   = list1.flatten
    println("List Flatten:::"+fl1)
    
    val list = List(List("subbu","Neelima"),List("tst","testing"))
    val lResult = list.flatten
    println("String list flatten::"+lResult)
    
    //Sorting above list and capitalize first char in every name
    val sorted = list.flatten.map(_.capitalize).sorted
    println(sorted)
    //Flatten on Array
    val array = Array(Array(1,2,3,4,5),Array(6,7,8,9,10))
    val result = array.flatten
    result.foreach {println}
    
    // Flatten on Vector
    val vector = Vector(Vector(1,2,3,4,5),Vector(6,7,8,9,10))
    val vResult = vector.flatten
    println("Vector Flatten::"+vResult)
    
    // Flatten on ArrayBuffer
    val ab = ArrayBuffer(ArrayBuffer(1,2,3,4,5),ArrayBuffer(6,7,8,9,10))
    val abResutl = ab.flatten
    println("ArrayBuffer Flatten::"+abResutl)
    
    //Avoiding Duplicates
    val myFriends = List("Adam", "David", "Frank")
    val adamsFriends = List("Nick K", "Bill M")
    val davidsFriends = List("Becca G", "Kenny D", "Bill M")
    val friendsOffriends = List(adamsFriends,davidsFriends)
    val uniqueFriendsOffriends = friendsOffriends.flatten.distinct.sorted
    println("uniqueFriendsOffriends::::"+uniqueFriendsOffriends)
    
  }
}