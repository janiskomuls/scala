package com.excentriq.learning

import com.excentriq.learning.TimeUtils._

object FoldReduce {
  private val ints: Seq[Int] = List(1, 2, 3, 4, 5, 6)
  // private val numbers: ParSeq[Int] = Range(1, 49000, 1).map(_ * 3 / 5337).par
  private val numbers: Seq[Int] = ints

  def main(args: Array[String]) {

    runAndTime(foldLeft, "foldLeft")
    runAndTime(foldLeft, "foldLeft")

    runAndTime(fold, "fold")
    runAndTime(fold, "fold")

    runAndTime(agg, "agg")
    runAndTime(agg, "agg")

    runAndTime(foldRight, "foldRight")
    runAndTime(foldRight, "foldRight")

    runAndTime(reduce, "reduce")
    runAndTime(reduce, "reduce")

    runAndTime(reduceLeft, "reduceLeft")
    runAndTime(reduceLeft, "reduceLeft")

    runAndTime(reduceRight, "reduceRight")
    runAndTime(reduceRight, "reduceRight")

    runAndTime(scanLeft, "scanLeft")
    runAndTime(scanRight, "scanRight")

    runAndTime(foldLeftList, "foldLeftList")
    runAndTime(foldRightList, "foldRightList")

    runAndTime(listWithSum(ints), "listWithSum")
    runAndTime(reduceLeftByFoldLeft(_ + _), "reduceLeftByFoldLeft")
  }

  def fold: Int = numbers.fold(0)(_ + _)

  def agg: Int = numbers.aggregate(0)(_ + _, _ + _)

  def foldLeft: Int = numbers.foldLeft(0)(
    (a, b) => {
      println(s"$a :: $b")
      a + b
    })

  def foldLeftList = numbers.foldLeft(List[Int]())((ls, e) => e :: ls)

  def foldRightList = numbers.foldRight(List[Int]())((e, ls) => e :: ls)

  def foldRight: Int = numbers.foldRight(0)(_ + _)

  def reduce: Int = numbers.reduce(_ + _)

  def reduceLeft: Int = numbers.reduceLeft(_ + _)

  def reduceRight: Int = numbers.reduceRight(_ + _)

  def scanLeft: Seq[Int] = numbers.scanLeft(0)(_ + _)

  def scanRight: Seq[Int] = numbers.scanRight(0)(_ + _)

  def reduceLeftByFoldLeft(f: (Int, Int) => Int) = numbers.tail.foldLeft(numbers.head)(f(_, _))

  def listWithSum(numbers: Seq[Int]) = numbers.foldLeft((List[Int](), 0)) {
    (resultingTuple, currentInteger) => {
      (currentInteger :: resultingTuple._1, currentInteger + resultingTuple._2)
    }
  }

}

