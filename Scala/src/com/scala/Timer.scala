package com.scala

object Timer {
  
  def oncePerSecond(callback:()=> Unit){
    while(true){
      callback();
      Thread sleep 10;
    }
  }
  def timeFiles(){
    println("Time files like arrow===>");
  }
  
  def main(args: Array[String]): Unit = {
    oncePerSecond(timeFiles);
  }
}