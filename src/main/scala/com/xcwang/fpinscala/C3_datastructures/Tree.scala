package com.xcwang.fpinscala.C3_datastructures

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(r, l) => size(r) + size(l) + 1
  }

  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(n) => n
    case Branch(r, l) => maximum(r) max maximum(l)
  }

  def depth(t: Tree[Int]): Int = t match {
    case Leaf(_) => 1
    case Branch(r, l) => (depth(r)+1) max (depth(l)+1)
  }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(n) => Leaf(f(n))
    case Branch(r, l) => Branch(map(r)(f), map(l)(f))
  }

  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(n) => f(n)
    case Branch(r, l) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  def sizeV2[A](t: Tree[A]): Int =
    fold[A, Int](t)(_=>1)(_+_+1)

  def maximumV2(t: Tree[Int]): Int =
    fold[Int, Int](t)(n=>n)(_ max _)

  def depthV2(t: Tree[Int]): Int =
    fold[Int, Int](t)(_=>1)(_+1 max _+1)

  def mapV2[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold[A, Tree[B]](t)(n => Leaf[B](f(n)))((r, l) => Branch(l, r))

}