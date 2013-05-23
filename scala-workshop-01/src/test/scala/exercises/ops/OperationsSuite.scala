package exercises.ops

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import exercises.ops._

@RunWith(classOf[JUnitRunner])
class OperationsSuite extends FunSuite {

  test("add 56 to 13 should return 3") {
    assert(Operations.add(56, 13) === 69)
  }

  test("sum of elements should be 10") {
    assert(Operations.sum(List(1, 2, 0, 7)) === 10)
  }

  test("length of elemens should be 3") {
    assert(Operations.length(List(1, 2, 0)) === 3)
  }

  test("should filter elements correctly") {
    assert(Operations.filter(List(1, 2, 3, 0, 6, 7), (x: Int) => x > 3) === List(6, 7))
    assert(Operations.filter(List(1, 2, 3, 0, 6, 7), (x: Int) => x == 3) === List(3))
    assert(Operations.filter(List(1, 2, 3, 0, 6, 7), (x: Int) => x < 0) === List())
  }
}