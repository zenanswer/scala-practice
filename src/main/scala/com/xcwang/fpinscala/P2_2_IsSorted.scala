package com.xcwang.fpinscala

object P2_2_IsSorted {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(x: Int): Boolean = {
      if (x > as.length -1) true
      else if(!ordered(as(x-1), as(x))) false
      else loop(x+1)
    }
    if (as.length > 1) loop(1)
    else false
  }
}
