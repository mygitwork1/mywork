package com.scala

object AnonymousFunctions {
  
  def oncePersecond(callback:()=>Unit){
    while(true){
      callback();
      Thread sleep 1000;
    }
  }
  
  def main(args: Array[String]): Unit = {
    oncePersecond (() => println("time flies like arrow!!!!!!"))
  }
  
}