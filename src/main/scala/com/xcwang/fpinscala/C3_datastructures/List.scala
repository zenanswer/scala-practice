package com.xcwang.fpinscala.C3_datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List{
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail:_*))
  }
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(head, tail) => head + sum(tail)
  }

  // P3_1 Match result
  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
  }

  // P3_2 tail func
  def tail[A](ints: List[A]): List[A] = ints match {
    case Nil => Nil
    case Cons(_, tail) => tail
  }

  // P3_3 setHead func
  def setHead[A](ints: List[A], newHead: A): List[A] = ints match {
    case Nil if newHead == null => Nil
    case Nil if newHead != null => Cons(newHead, Nil)
    case Cons(_, tail) => Cons(newHead, tail)
  }

  // P3_4 drop func
  def drop[A](l: List[A], n: Int): List[A] = n match {
    case 0 => l
    case _: Int if l == Nil => Nil
    case x: Int if l != Nil=> drop(tail(l), x-1)
  }

  // P3_5 dropWhile func
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
//    case Nil => Nil
//    case Cons(head, _) if !f(head) => l
//    case Cons(head, _) if f(head) => dropWhile(tail(l), f)
    case Cons(head, _) if f(head) => dropWhile(tail(l), f)
    case _ => l
  }

  // Here is a curry version of dropWhile2
  def dropWhile2[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(head, tail) if f(head) => dropWhile2(tail)(f)
    case _ => l
  }

  // def add(x:Int)=(y:Int)=>x+y
  def dropWhile2_0[A](l: List[A]) = (f: A => Boolean) => {
    l match {
      case Cons(head, tail) if f(head) => dropWhile2(tail)(f)
      case _ => l
    }
  }

  // P3_6 init func
  def init[A](l:List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(head, tail) => Cons(head, init(tail))
  }
}
