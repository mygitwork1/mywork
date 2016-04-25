package com.scala

class InheritanceAndOverride(rel:Integer,img:Integer) {
  def re = rel;
  def im = img
  
  override def toString()= ""+re+(if (im<0)""else"+")+im+"i"
}