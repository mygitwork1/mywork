package com.scala

import java.util.{Date,Locale}
import java.text.DateFormat;
import java.text.DateFormat._

object Test {
  
  def test(){
  
    println("test!!!!!")
  }
  
  def main(args: Array[String]){
   val now = new Date;
    val df = getDateInstance(LONG, Locale.UK)
    println(df format now)
    val comp = new Complex(1,2);
    val a = comp.one1;
    println(a)
    
    val b= new InheritanceAndOverride(1,3);
    println(b.im)
   
  }
}