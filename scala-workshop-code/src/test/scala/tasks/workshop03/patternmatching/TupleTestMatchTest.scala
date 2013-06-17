package tasks.workshop03.patternmatching

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import junit.framework.Assert._
import org.scalatest.FunSuite


@RunWith(classOf[JUnitRunner])
class TupleTestMatchTest extends FunSuite {

  test("matchOnTupes") {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      // Match on the tuple, and assert that its the same => assertEquals(simpleTuple, (one, two))
      case _ => sys.error("Couldnt match it")
    }
  }

  test("matchOnTupesWithGuard") {
    val simpleTuple: Any = (1, "string")

    simpleTuple match {
      case (one, _) => assertEquals(2, one)
      // Comment in this line and make this run, (hint create guard on the previous match, so that it won't hit)
      // case (one, _) => assertEquals(1, one)
      case _ => sys.error("Couldnt match it")
    }
  }

  test("matchOnLargerTuple") {
    val simpleTuple: Any = (1, "string", false)

    simpleTuple match {
      // Match on the tuple, and assert with assertFalse(three)
      case (one, two, three: String) => sys.error("this is not a Tuple3 with last element Boolean")
      case _ => sys.error("Couldnt match it")
    }
  }
}
