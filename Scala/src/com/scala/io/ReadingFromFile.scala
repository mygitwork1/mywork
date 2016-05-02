package com.scala.io

import scala.io.Source

object ReadingFromFile {
  def main(args: Array[String]): Unit = {
    println("Following is the content read::")
    Source.fromFile("C:/Users/subbarao/Desktop/input.txt").foreach { print }
  }
}