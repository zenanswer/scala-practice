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
}
