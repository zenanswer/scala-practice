package com.xcwang.fpinscala.C2_gettingstarted

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P2_3_CurryingTest extends WordSpec {

  "curry" in {
    def myOrigFunc (x: Int, y: Double): String = {
      x.toString + ":" + y.toString
    }

    val myCurryFunc = P2_3_Currying.curry(myOrigFunc)

    myCurryFunc(1)(2.0) shouldBe "1:2.0"
  }

}
