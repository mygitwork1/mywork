package com.scala.exceptionhandling

import java.io.FileNotFoundException
import java.io.IOException
import java.io.FileReader

object FinallyClause {
  def main(args: Array[String]): Unit = {
    try {
      val file = new FileReader("input.txt")
      
    } catch {
      case ex: FileNotFoundException =>{
       println("File missing exception!!!!")
      }
      case ex: IOException =>{
        println("IO Exception!!!!")
      }
    }finally {
      println("Exiting finally!!!!")
    }
  }
}