package com.xcwang.fpinscala.C3_datastructures

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P3_ListTest extends WordSpec {
  "P3_1 Match result" when {
    "List.x" should {
      "3" in {
        List.x shouldBe 3
      }
    }
  }
  "P3_2 tail func" when {
    "List(1,2,3).tail" should {
      "List(2,3)" in {
        List.tail(List(1,2,3)) shouldEqual List(2,3)
      }
    }
    "Nil.tail" should {
      "Nil" in {
        List.tail(Nil) shouldEqual Nil
      }
    }
  }
  "P3_3 setHead func" when {
    "List(1,2,3).setHead(4)" should {
      "List(4, 2,3)" in {
        List.setHead(List(1,2,3), 4) shouldEqual List(4, 2,3)
      }
    }
    "Nil.setHead(4)" should {
      "List(4)" in {
        List.setHead(Nil, 4) shouldEqual List(4)
      }
    }
    "Nil.setHead(null)" should {
      "Nil" in {
        List.setHead(Nil, null) shouldEqual Nil
      }
    }
  }
  "P3_4 drop func" when {
    "List(1,2,3,4).drop(2)" should {
      "List(3,4)" in {
        List.drop(List(1,2,3,4), 2) shouldEqual List(3,4)
      }
    }
    "List(1,2,3,4).drop(5)" should {
      "Nil" in {
        List.drop(List(1,2,3,4), 5) shouldEqual Nil
      }
    }
    "Nil.drop(2)" should {
      "Nil" in {
        List.drop(Nil, 2) shouldEqual Nil
      }
    }
  }
  "P3_5 dropWhile func" when {

    def genConditionFunc[A](condition: Int): A => Boolean = {
      def conditionFunc[A](x: A) : Boolean = x match {
        case n: Int =>  n<condition
        case _ => false
      }
      conditionFunc
    }

    "List(1,2,3,4).dropWhile(_<3)" should {
      "List(3,4)" in {
        List.dropWhile(List(1,2,3,4), genConditionFunc(3)) shouldEqual List(3,4)
      }
    }
    "List(1,2,3,4).dropWhile(_<5)" should {
      "List(3,4)" in {
        List.dropWhile(List(1,2,3,4), genConditionFunc(5)) shouldEqual Nil
      }
    }
    "List(1,2,3,4).dropWhile(_<1)" should {
      "List(1,2,3,4)" in {
        List.dropWhile(List(1,2,3,4), genConditionFunc(1)) shouldEqual List(1,2,3,4)
      }
    }
    "Nil.dropWhile(_<2)" should {
      "Nil" in {
        List.drop(Nil, 2) shouldEqual Nil
      }
    }
  }
  "P3_5 dropWhile V2 func" when {
    "List(1,2,3,4).dropWhile2(_<3)" should {
      "List(3,4)" in {
        List.dropWhile2(List(1, 2, 3, 4))(_<3) shouldEqual List(3, 4)
      }
    }
  }
  "P3_5 dropWhile primitive V2 func" when {
    "List(1,2,3,4).dropWhile2_0(_<3)" should {
      "List(3,4)" in {
        List.dropWhile2_0(List(1, 2, 3, 4))((x: Int) => x<3) shouldEqual List(3, 4)
      }
    }
  }
  "P3_6 init func" when {
    "Nil.init" should {
      "Nil" in {
        List.init(Nil) shouldEqual Nil
      }
    }
    "List(1).init" should {
      "Nil" in {
        List.init(List(1)) shouldEqual Nil
      }
    }
    "List(1,2).init" should {
      "List(1)" in {
        List.init(List(1,2)) shouldEqual List(1)
      }
    }
    "List(1,2,3).init" should {
      "List(1,2)" in {
        List.init(List(1,2,3)) shouldEqual List(1,2)
      }
    }
    "List(1,2,3,4).init" should {
      "List(1,2,3)" in {
        List.init(List(1,2,3,4)) shouldEqual List(1,2,3)
      }
    }
  }
}
