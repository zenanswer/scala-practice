package com.xcwang.fpinscala.C3_datastructures

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P3_TreeTest extends WordSpec {

  val tree7: Branch[Int] = Branch[Int](
    Branch[Int](
      Leaf[Int](1),
      Leaf[Int](5)),
    Branch[Int](
      Leaf[Int](8),
      Leaf[Int](4)))

  val tree7plus: Branch[Int] = Branch[Int](
    Branch[Int](
      Leaf[Int](2),
      Leaf[Int](6)),
    Branch[Int](
      Leaf[Int](9),
      Leaf[Int](5)))

  val tree9: Branch[Int] = Branch[Int](
    Branch[Int](
      Branch[Int](
        Leaf[Int](1),
        Leaf[Int](5)),
      Branch[Int](
        Leaf[Int](3),
        Leaf[Int](9))),
    Branch[Int](
      Leaf[Int](8),
      Leaf[Int](4)))

  val tree9String: Branch[String] = Branch[String](
    Branch[String](
      Branch[String](
        Leaf[String]("1"),
        Leaf[String]("5")),
      Branch[String](
        Leaf[String]("3"),
        Leaf[String]("9"))),
    Branch[String](
      Leaf[String]("8"),
      Leaf[String]("4")))

  "P3_25 size result" when {
    "Tree 7 " should {
      "7" in {
        Tree.size(tree7) shouldBe 7
      }
    }
    "Tree 7 (fold version)" should {
      "7" in {
        Tree.sizeV2(tree7) shouldEqual 7
      }
    }
  }
  "P3_26 maximum result" when {
    "Tree 7 " should {
      "8" in {
        Tree.maximum(tree7) shouldBe 8
      }
    }
    "Tree 7 (fold version)" should {
      "8" in {
        Tree.maximumV2(tree7) shouldBe 8
      }
    }
  }
  "P3_27 depth result" when {
    "Tree 7 " should {
      "3" in {
        Tree.depth(tree7) shouldBe 3
      }
    }
    "Tree 7 (fold version)" should {
      "3" in {
        Tree.depthV2(tree7) shouldBe 3
      }
    }
    "Tree 9 " should {
      "4" in {
        Tree.depth(tree9) shouldBe 4
      }
    }
  }
  "P3_28 map result" when {
    "Tree 7, Leaf ++ " should {
      "Tree 7 plus" in {
        Tree.map(tree7)(_+1) shouldEqual tree7plus
      }
    }
    "Tree 7, Leaf ++ (fold version)" should {
      "Tree 7 plus" in {
        Tree.mapV2(tree7)(_+1) shouldEqual tree7plus
      }
    }
    "Tree 9, Leaf toString " should {
      "Tree 9 string" in {
        Tree.map(tree9)(_.toString) shouldEqual tree9String
      }
    }
    "Tree 9, Leaf toString (fold version)" should {
      "Tree 9 string" in {
        Tree.mapV2(tree9)(_.toString) shouldEqual tree9String
      }
    }
  }
  // P3_29 fold version, above
}