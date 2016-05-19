package com.scala

class InnerClass {
  class Inner{
    private def f(){println("F")}
        class InnerMost{
          f()// OK
        }
  
  }
  //(new Inner).f()//: Error: f is not accessible
}