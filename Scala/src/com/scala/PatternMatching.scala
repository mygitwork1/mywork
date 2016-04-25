package com.scala

object PatternMatching {
  def main(args: Array[String]): Unit = {
    val matchWpg="^.*Winnipeg.*$".r
    
    val teams = List(
                      "Toronto Raptors",
                      "Los Angeles Kings",
                      "Minneapolis Twins",
                      "Winnipeg Blue Bombers",
                      "Winnipeg Jets",
                      "San Francisco 49ers",
                      "Edmonton Eskimos")
                      
     for(team<-teams){
       team match{
         case matchWpg()=>println("Go team!!")
         case _ =>println("bad luck")
       }
     }
    
    
    println("Would you like to be a violater!!!!")
    val searchLine = readLine
    searchLine match{
      case "hai"=>println("i want violate rules!!!")
      case "bye"=>println("i dont want violate the rules!!!!!!")
      case _ =>println("see you soon !!!!!")
    }
                      
  }
}