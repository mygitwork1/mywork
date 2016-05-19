package com.scala.patternmatching


object PatternMatchingUsingCaseClass {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("subbu",31)
    val p2 = new Person("neelima",29)
    val p3 = new Person("aadhya",12)

    for(person<-List(p1,p2,p3)){
      person match{
        case Person("subbu",31)=>println("Hello subbu!!!")
        case Person("neelima",29)=>println("Hello neelima!!!")
       // case Person("aadhya",12)=>println("Hello aadhya!!!")
        case Person(name,age) => println("age"+age+":: name::"+name)
      }
    }
    
  }
  case class Person(name:String,age:Int)
}