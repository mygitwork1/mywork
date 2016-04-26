package com.scala.strings

object CreatingFormatingString {
  def main(args: Array[String]): Unit = {
    var floatVar = 1.2
    var ingVar   = 12
    var string   = "Hello!!"
    var fs       = printf("The value of the float is %f"+
                          ", while vlaue of the integer is %d"+
                          ", and String is :: %s",floatVar,ingVar,string)
    println(fs)                       
  }
}