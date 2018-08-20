package com.xcwang.fpinscala


object FibonacciSequence {

  def fib(n: Int): Int = n match {
    case 1 | 2 => 1
    case x: Int => fib(x-1)+fib(x-2)
  }

  def calculate(n: Int): List[Int] = n match {
    case 1 => List(1)
    case 2 => List(1, 1)
    case x: Int => calculate(x-1)++List(fib(x))
  }

  val fibs:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }

  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
}
