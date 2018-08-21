package com.xcwang.fpinscala.C2_gettingstarted

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P2_4_UnCurryingTest extends WordSpec {
  "uncurry" in {
    def myOrigFunc (x: Int): Double => String = {
      y: Double => {
        x.toString + ":" + y.toString
      }
    }

    val myUnCurryFunc = P2_4_UnCurrying.uncurry(myOrigFunc)

    myUnCurryFunc(2, 3.0) shouldBe "2:3.0"
  }

}
