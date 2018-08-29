package com.xcwang.fpinscala.C3_datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
case class ConsLeft[+A](head: List[A], tail: A) extends List[A]

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
  val x: Int = List(1,2,3,4,5) match {
    case Cons(h, Cons(2, Cons(4, _))) => h
    case Nil => 42
    case Cons(h, Cons(h2, Cons(3, Cons(4, _)))) => h + h2
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
  def dropWhile2_0[A](l: List[A]):((A=>Boolean)=>List[A]) = (f: A => Boolean) => {
    l match {
      case Cons(head, tail) if f(head) => dropWhile2_0(tail)(f)
      case _ => l
    }
  }

  // P3_6 init func
  def init[A](l:List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(head, tail) => Cons(head, init(tail))
  }


  def foldRight[A, B](l: List[A], z:B)(f: (A, B)=>B):B = {
    l match {
      // z is a initial value
      case Nil => z
      case Cons(head, tail) => f(head, foldRight(tail, z)(f))
      // foldRight(Cons(1,Cons(2,Cons(3,Cons(4,Nil)))), z)(f)
      // ---------(-----------------------------------, -)(-)
      // f(1, foldRight(Cons(2,Cons(3,Cons(4,Nil))), z)(f))
      //      ---------(---------------------------, -)(-)
      // f(1, f(2, foldRight(Cons(3,Cons(4,Nil)), z)(f)))
      //           ---------(-------------------, -)(-)
      // f(1, f(2, f(3, foldRight(Cons(4,Nil), z)(f))))
      //                ---------(-----------, -)(-)
      // f(1, f(2, f(3, f(4, foldRight(Nil, z)(f)))))
      //                     ---------(---, -)(-)
      // f(1, f(2, f(3, f(4, z))))
    }
  }

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((_:A, x:Int)=>x+1)
  }

  def foldLeft[A, B](l: List[A], z:B)(f: (B, A)=>B):B = {
    l match {
      case Nil => z
      case Cons(head, tail) => foldLeft(tail, f(z,head))(f)
    }
    // foldLeft(Cons(1,Cons(2,Cons(3,Cons(4,Nil)))), z)(f)
    // --------(-----------------------------------, -)(-)
    // foldLeft(Cons(2,Cons(3,Cons(4,Nil))), f(z,1))(f)
    // --------(---------------------------, ------)(-)
    // foldLeft(Cons(3,Cons(4,Nil)), f(f(z,1),2))(f)
    // --------(-------------------, -----------)(-)
    // foldLeft(Cons(4,Nil), f(f(f(z,1),2),3))(f)
    // --------(-----------, ----------------)(-)
    // foldLeft(Nil, f(f(f(f(z,1),2),3),4))(f)
    // --------(---, ---------------------)(-)
    // f(f(f(f(z,1),2),3),4)
  }

  def reverse[A](l: List[A]): List[A] = {
    foldLeft(l, Nil: List[A])((x:List[A], y:A) => Cons(y, x))
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }
//  TODO
//  def appendLeft[A](l: List[A], n: A): List[A] = l match {
//    case Nil => List(n)
//    case Cons(head, tail) => foldLeft(tail, f(n, head, tail))
//  }
  def plus1(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case Cons(head, tail) => Cons(head+1, plus1(tail))
  }

  def map[A, B](l: List[A])(f: A=>B): List[B] = l match {
    case Nil => Nil
    case Cons(head, tail) => Cons(f(head), map(tail)(f))
  }

//  def filter[A](as: List[A])(f: A=>Boolean): List[A] = as match {
//    case Nil => Nil
//    case Cons(head, tail) => if(f(head)) Cons(head, filter(tail)(f)) else filter(tail)(f)
//  }
  def filter[A](as: List[A])(f: A=>Boolean): List[A] = {
    foldRight(as, Nil: List[A])((h,t) => if (f(h)) Cons(h,t) else t)
  }

  def flatMap[A, B](as: List[A])(f: A=>List[B]): List[B] = as match {
    case Nil => Nil
    case Cons(head, tail) => append(f(head), flatMap(tail)(f))
  }

  def filter2[A](as: List[A])(f: A=>Boolean): List[A] = {
    List.flatMap(as)(i=>if(f(i))List(i) else Nil)
  }

  def zipWith[A,B,C](l1: List[A], l2:List[B])(f: (A, B)=>C): List[C] = (l1, l2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1,t1), Cons(h2,t2)) => Cons(f(h1,h2), zipWith(t1,t2)(f))
  }

  def hasSubSeq[A](l1: List[A], l2: List[A]): Boolean = (l1, l2) match {
    case (Nil, _) => false
    case (_, Nil) => true
    case (Cons(h1,t1), Cons(h2,t2))  =>
      if (h1 == h2) hasSubSeq(t1, t2) else hasSubSeq(t1, Cons(h2,t2))
  }
}
