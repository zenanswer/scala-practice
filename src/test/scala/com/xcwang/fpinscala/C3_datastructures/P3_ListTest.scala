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
      def conditionFunc(x: A) : Boolean = x match {
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
  "foldRight func" when {
    "List(1,2,3,4) and A+B" should {
      "10" in {
        List.foldRight(List(1,2,3,4), 0)(_+_) shouldEqual 10
      }
    }
    //P3_8
    "List(1,2,3,4) and Cons(_+_)" should {
      "List(1,2,3,4)" in {
        List.foldRight(List(1,2,3,4), Nil: List[Int])(Cons(_, _)) shouldEqual List(1,2,3,4)
      }
    }
    //P3_9
    "List(1,2,3,4) 's length bases on foldRight" should {
      "4" in {
        List.length(List(1,2,3,4)) shouldEqual 4
      }
    }
  }
  //P3_10
  "foldLeft func" when {
    //P3_11
    "List(1,2,3,4) and A+B" should {
      "10" in {
        List.foldLeft(List(1,2,3,4), 0)(_+_) shouldEqual 10
      }
    }
    "List(1,2,3,4) and Cons(_+_)" should {
      "not List(1,2,3,4) Cons, but ConsLeft" in {
        List.foldLeft(List(1,2,3,4), Nil: List[Int])(ConsLeft(_, _)) shouldEqual ConsLeft(ConsLeft(ConsLeft(ConsLeft(Nil,1),2),3),4)
      }
    }
  }
  //P3_12
  "reverse func" when {
    "List(1,2)" should {
      "List(2,1)" in {
        List.reverse(List(1, 2)) shouldEqual List(2, 1)
      }
    }
    "List(1,2,3,4)" should {
      "List(4,3,2,1)" in {
        List.reverse(List(1, 2, 3, 4)) shouldEqual List(4, 3, 2, 1)
      }
    }
    "Nil" should {
      "Nil" in {
        List.reverse(Nil) shouldEqual Nil
      }
    }
  }
  //P3_14
  "append func" when {
    "List(1,2).append List[3,4]" should {
      "List(1,2,3,4)" in {
        List.append(List(1, 2), List(3,4)) shouldEqual List(1, 2, 3,4)
      }
    }
  }
  "P3_16 plus 1 func" when {
    "List(1,2,3,4)" should {
      "List(2,3,4,5)" in {
        List.plus1(List(1, 2, 3, 4)) shouldEqual List(2, 3, 4, 5)
      }
    }
  }
  "P3_17/18 Double to String bases foreach func" when {
    "List(1.0,2.0,3.0,4.0)" should {
      "List(\"1.0\", \"2.0\", \"3.0\", \"4.0\")" in {
        List.map(List(1.0,2.0,3.0,4.0))(_.toString) shouldEqual List("1.0", "2.0", "3.0", "4.0")
      }
    }
  }
  "P3_19 filter func" when {
    "List(1,2,3,4,5,6)" should {
      "List(2,4,6)" in {
        List.filter(List(1,2,3,4,5,6))(_%2 == 0) shouldEqual List(2,4,6)
      }
    }
  }
  "P3_20 flatMap func" when {
    "List(1,2,3,4)" should {
      "List(1,1,2,2,3,3,4,4)" in {
        List.flatMap(List(1,2,3,4))(i=>List(i,i)) shouldEqual List(1,1,2,2,3,3,4,4)
      }
    }
  }
  "P3_21 filter bases flatMap func" when {
    "List(1,2,3,4,5,6)" should {
      "List(2,4,6)" in {
        //List.flatMap(List(1,2,3,4,5,6))(i=>if(i%2==0)List(i) else Nil) shouldEqual List(2,4,6)
        List.filter2(List(1,2,3,4,5,6))(_%2 == 0) shouldEqual List(2,4,6)
      }
    }
  }
  "P3_22/23 zipWith func" when {
    "List(1,2,3) List(4,5,6)" should {
      "List(5,7,9)" in {
        List.zipWith(List(1,2,3), List(4,5,6))(_+_) shouldEqual List(5,7,9)
      }
    }
  }
  "P3_24 hasSubSeq func" when {
    "List(1,2,3,4,5,6) List(3,4,5)" should {
      "true" in {
        List.hasSubSeq(List(1, 2, 3, 4, 5, 6), List(3, 4, 5)) shouldBe true
      }
    }
  }
}
