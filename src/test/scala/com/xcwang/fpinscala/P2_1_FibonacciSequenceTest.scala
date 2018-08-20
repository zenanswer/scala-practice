package com.xcwang.fpinscala

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.WordSpec
import org.scalatest.Matchers._

@RunWith(classOf[JUnitRunner])
class P2_1_FibonacciSequenceTest extends WordSpec {
  "FibonacciSequence" when {
    "n=1 calculate result" should {
      "be 1" in {
        FibonacciSequence.calculate(1) shouldEqual List(1)
      }
    }
    "n=2 calculate result" should {
      "be 1,1" in {
        FibonacciSequence.calculate(2) shouldEqual List(1, 1)
      }
    }
    "n=3 calculate result" should {
      "be 1, 1, 2" in {
        FibonacciSequence.calculate(3) shouldEqual List(1, 1, 2)
      }
    }
    "n=4 calculate result" should {
      "be 1, 1, 2, 3" in {
        FibonacciSequence.calculate(4) shouldEqual List(1, 1, 2, 3)
      }
    }
    "n=5 calculate result" should {
      "be 1, 1, 2, 3, 5" in {
        FibonacciSequence.calculate(5) shouldEqual List(1, 1, 2, 3, 5)
      }
    }
    "n=6 calculate result" should {
      "be 1, 1, 2, 3, 5, 8" in {
        FibonacciSequence.calculate(6) shouldEqual List(1, 1, 2, 3, 5, 8)
      }
    }
    "21(n=8) calculate result" should {
      "be 0, 1, 1, 2, 3, 5, 8, 13" in {
        FibonacciSequence.fibs.take(8).toList  shouldEqual List(0, 1, 1, 2, 3, 5, 8, 13)
        FibonacciSequence.fibs.takeWhile(_<21).toList shouldEqual List(0, 1, 1, 2, 3, 5, 8, 13)
        FibonacciSequence.fibFrom(0, 1).takeWhile(_<21).toList shouldEqual List(0, 1, 1, 2, 3, 5, 8, 13)
      }
    }
  }
}

