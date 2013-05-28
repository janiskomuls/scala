package tasks.workshop01.recursion

// You are not permitted to use these List methods:
// * length
// * map
// * filter
// * ::: (and variations such as ++)
// * flatten
// * flatMap
// * reverse (and variations i.e. reverseMap, reverse_:::)
// This also means you are not permitted to use for-comprehensions on Lists.
// You are permitted to use the functions you write yourself. For example, Exercise 2 may use Exercise 1 or Exercise 3.
// Try to use:
// * recursion
// * fold
// * reduce

object Operations {

  def succ(n: Int) = n + 1
  def pred(n: Int) = n - 1

  def add(x: Int, y: Int): Int = error("todo: Assume x and y are 0 or positive. Do not use + or - on Int. Only permitted to use succ/pred (above).")

  def sum(x: List[Int]): Int = error("todo")

  def length[A](x: List[A]): Int = error("todo")

  def filter[A](x: List[A], f: A => Boolean): List[A] = error("todo: second parameter is function")
}