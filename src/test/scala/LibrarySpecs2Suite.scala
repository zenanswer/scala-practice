/*
 * A example for Specs2
 */
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.WordSpec
import org.scalatest.Matchers._

@RunWith(classOf[JUnitRunner])
class LibrarySpecs2Suite extends WordSpec {
  "someLibraryMethod" when {
    "is always" should {
      "true" in {
        val library = new Library()
        library.someLibraryMethod shouldBe true
      }
    }
  }
}
