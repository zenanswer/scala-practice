package com.xcwang.fpinscala.C2_gettingstarted

object P2_5_Compose {

  def compose[A, B, C] (f: B => C, g: A => B): A => C = {
    a: A => f(g(a))
  }
//  def compose[A, B, C] (f: B => C, g: A => B): A => C = {
//    (a: A) => f(g(a))
//  }
}
