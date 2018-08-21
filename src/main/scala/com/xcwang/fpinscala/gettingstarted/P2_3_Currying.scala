package com.xcwang.fpinscala.gettingstarted

object P2_3_Currying {

  def curry[A, B, C] (f: (A, B) => C): A => B => C = {
    a: A => b: B => f(a, b): C
  }
//  def curry[A, B, C] (f: (A, B) => C): A => (B => C) = {
//    (a: A) => (b: B) => f(a, b): C
//  }
}
