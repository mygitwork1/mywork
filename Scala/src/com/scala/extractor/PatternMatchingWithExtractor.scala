package com.scala.extractor

object PatternMatchingWithExtractor {
  def main(args: Array[String]){
   /* //val x = PatternMatchingWithExtractor(5)
   // println(x)
    x match{
      case PatternMatchingWithExtractor(num)=>println(x+" is bigger two times than "+num)
      case _ => println("i cannot caliculate!!!")
    }*/
  }
  def Apply(x:Int) = x*2
  def unapply(z:Int):Option[Int]= if(z%2==0)Some(z/2)else None
  
}