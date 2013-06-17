package tasks.workshop03.patternmatching

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class MyCaseClassMatchingTest extends FunSuite {

  test("matchMySuperType") {
    val theClass: Any = FirstSubClass(1)

    val found = theClass match {
      // Add a match expression which return true
      case _ => false
    }
    assert(found)
  }

  test("matchSubType") {

    def matchSubType(myType: MyCaseClass) = myType match {
      // Add match expressions which make the following code pass.
      case _ => sys.error("Should never reach this")
    }

    // You should not change the following code at all. Only add matches which will make the tests match.
    var theClass: MyCaseClass = FirstSubClass(10)
    var foundElement = matchSubType(theClass)
    assert(10 === foundElement)

    theClass = SecondSubClass("verdi")
    foundElement = matchSubType(theClass)
    assert("verdi" === foundElement)

    theClass = ThirdSubClass("verdi", List(1, 2))
    foundElement = matchSubType(theClass)
    assert(List(1, 2) === foundElement)

    theClass = FourthSubClass("verdi", FirstSubClass(11))
    foundElement = matchSubType(theClass)
    assert(11 === foundElement)
  }

  test("matchWithExplicitType") {
    val theClass: MyCaseClass = FourthSubClass("verdi", FirstSubClass(11))

    val foundElement: Option[FirstSubClass] = theClass match {
      // Add a match expression which make the following assertion true. Use Option type
      case _ => None
    }

    assert(FirstSubClass(11) === foundElement.get)
  }

}
