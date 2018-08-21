package com.xcwang.fpinscala.C2_gettingstarted

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P2_5_ComposeTest extends WordSpec {

  "compose" in {
    def myFooFunc(y: Int): String = {
      y.toString
    }

    def mGuuFunc(x: Double): Int = {
      x.toInt
    }

    val myComposeFunc = P2_5_Compose.compose(myFooFunc, mGuuFunc)

    myComposeFunc(2.0) shouldBe "2"
  }

}
