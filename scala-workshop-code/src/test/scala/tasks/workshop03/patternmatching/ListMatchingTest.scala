package tasks.workshop03.patternmatching

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class ListMatchingTest extends FunSuite {

  val list = List("Scala", "is", "powerful")

  test("matchFirstElementOfList") {

    // matchedElement must find the first element. It can also skip the rest (if you want to)
    val mathedElement = list match {
      // Insert you match statement(s) here
      case _ => "failed"
    }

    assert(list(0) === mathedElement)
  }

  test("matchSecondElementOfList") {

    // matchedElement should find the second element of the list. 
    // You may ignore the first element and any subsequent elements if you want
    val mathedElement = list match {
      // Insert you match statement here
      case _ => "failed"
    }

    assert(list(1) === mathedElement)
  }

  test("matchNestedLists") {
    val nestedList = list :: List("Indeed", "it", "is")
    // Same as List(List(Scala, is, powerful), Indeed, it, is) 

    // A side note here. If you want only one list use "list ::: List("Indeed", "it", "is")" 
    // Which prepends the entire list.

    // You must find the sublist to make the test pass.
    val mathedElement = nestedList match {
      // Insert you match statement here
      case _ => "failed"
    }

    assert(list === mathedElement)
  }

  test("matchNestedElementOfList") {
    val subList = List("Indeed", "it", "is")
    val list = List("Scala", "is", "powerful", subList)

    // Here you must find the first element of the second sublist
    val mathedElement = list match {
      // Insert you match statement here
      case _ => "failed"
    }
    assert(subList(0) === mathedElement)
  }

}
