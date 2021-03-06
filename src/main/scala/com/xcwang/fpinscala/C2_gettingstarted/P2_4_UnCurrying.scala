package com.xcwang.fpinscala.C2_gettingstarted

object P2_4_UnCurrying {

  def uncurry[A, B, C] (f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b): C
  }
}
