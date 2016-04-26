package com.scala

object AnonymousFunctions {
  
  def oncePersecond(callback:()=>Unit){
    while(true){
      callback();
      Thread sleep 300000;
    }
  }
  
  
  def main(args: Array[String]): Unit = {
    oncePersecond (() => println("time flies like arrow!!!!!!"))
    val inc = (x:Int)=>x+1
    println(inc)
  }
  
}