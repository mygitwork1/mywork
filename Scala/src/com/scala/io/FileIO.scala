package com.scala.io

import java.io.PrintWriter
import java.io.File

object FileIO {
  /**
   * When the above code is compiled and executed, it creates a file(input.txt) with "Hello Scala" content
   */
  
  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("C:/Users/subbarao/Desktop/input.txt"))
    writer.write("Hello scala")
    writer.close()
  }
}