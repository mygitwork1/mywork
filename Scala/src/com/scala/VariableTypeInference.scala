package com.scala

object VariableTypeInference {
  def main(args: Array[String]): Unit = {
    var i:Int=10 // No TypeInference
    val s = "Hello Scala!!!"//TypeInference
    
    val(name:String,age:Int) = ("subbu",32)// No typeInference
    var (name1,age1)= ("neelima",28)
  }
}