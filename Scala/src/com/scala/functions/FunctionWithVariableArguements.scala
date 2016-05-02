package com.scala.functions

object FunctionWithVariableArguements {
  /**
   * This allows clients to pass variable length argument lists to the function
   */
  def main(args: Array[String]): Unit = {
    printString("Hello","Welcome","Scala")
  }
  def printString(args:String*)={
    var i:Int = 0
    for(args<-args){
     println("Args value["+i+"]"+args)
      i = i+1
    }
    
  }
}