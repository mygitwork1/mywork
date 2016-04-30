package com.scala.extractor

object Extractor {
  def main(args: Array[String]): Unit = {
    println("Apply Mehtod :"+Apply("subbu","gmail.com"))
    println("UnApply Mehtod :"+unapply("subbu@gmail.com"))
    println("UnApply Mehtod :"+unapply("subbu gmail.com"))
  }
  def Apply(name:String,domain:String)={
    name+"@"+domain
  }
  
  //Extraction method
  def unapply(str:String):Option[(String,String)]={
    val parts = str split "@"
    if(parts.length == 2){
      Some(parts(0),parts(1))
    }else{
      None
    }
  }
}