package com.scala

object Operators {
  def main(args: Array[String]): Unit = {
    // Arithmetic Operators
    var a = 10
    var b = 20
    println(a+b)
    println(a-b)
    println(b*a)
    println(b/a)
    println(b%a)
    
    //Relational Operators
    if(a<b){println(true)}
    if(a<=b){println(true)}
    if(a>b){println(false)}
    if(a>=b){println(false)}
    if(a==b){println(false)}
    if(a!=b){println(true)}
    
    // Logical Operators
    var c = 1
    var d = 1
    //if(c&&d){println(true)}
    
    //Assignment Operators
    a = c+d
   println(a)
    a+=d
   println(a) 
    
  }
}