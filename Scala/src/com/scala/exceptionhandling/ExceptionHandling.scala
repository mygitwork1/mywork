package com.scala.exceptionhandling

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object ExceptionHandling {
  def main(args: Array[String]): Unit = {
    try {
      val file = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
         println("File missing exception!!!")
      }
      case ex : IOException =>{
        println("IO Exception!!!!")
      }
    }
  }
}