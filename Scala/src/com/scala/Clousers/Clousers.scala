package com.scala.Clousers

object Clousers {
  def main(args: Array[String]): Unit = {
    println("Multiplier(1) value= "+multiplier(1))
    println("Multiplier(2) value= "+multiplier(2))
    println("Multiplier(3) value= "+multiplier(3))
  }
  
  var factor =3
  var multiplier = (i:Int)=>i*factor
}