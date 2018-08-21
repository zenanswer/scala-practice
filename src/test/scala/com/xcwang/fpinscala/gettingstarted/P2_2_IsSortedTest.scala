package com.xcwang.fpinscala.gettingstarted

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P2_2_IsSortedTest extends WordSpec {
  "IsSorted" when {
    "Array[Int] (1)" should {
      "false" in {
        P2_2_IsSorted.isSorted(Array(1), (x: Int, y: Int) => x < y) shouldBe false
      }
    }
    "Array[Int] (2, 1)" should {
      "false" in {
        P2_2_IsSorted.isSorted(Array(2, 1), (x: Int, y: Int) => x < y) shouldBe false
      }
    }
    "Array[Int] (1, 2)" should {
      "true" in {
        P2_2_IsSorted.isSorted(Array(1, 2), (x: Int, y: Int) => x < y) shouldBe true
      }
    }
    "Array[Int] (1, 2, 3)" should {
      "true" in {
        P2_2_IsSorted.isSorted(Array(1, 2, 3), (x: Int, y: Int) => x < y) shouldBe true
      }
    }
    "Array[Int] (1, 2, 3, 4)" should {
      "true" in {
        P2_2_IsSorted.isSorted(Array(1, 2, 3, 4), (x: Int, y: Int) => x < y) shouldBe true
      }
    }
  }
}