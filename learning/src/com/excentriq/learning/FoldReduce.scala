package com.excentriq.learning

import com.excentriq.learning.TimeUtils.runAndTime

import scala.collection.parallel.immutable.ParSeq

object FoldReduce {
  def main(args: Array[String]) {
    runAndTime(foldLeft, "foldLeft")
    runAndTime(foldLeft, "foldLeft")
    runAndTime(foldLeft, "foldLeft")
    runAndTime(fold, "fold")
    runAndTime(fold, "fold")

    runAndTime(agg, "agg")
    runAndTime(agg, "agg")

    //    runAndTime(foldRight, "foldRight")
    //    runAndTime(foldRight, "foldRight")
    runAndTime(reduce, "reduce")
    runAndTime(reduce, "reduce")
    runAndTime(reduceLeft, "reduceLeft")
    runAndTime(reduceLeft, "reduceLeft")
    //    runAndTime(reduceRight, "reduceRight")
    //    runAndTime(reduceRight, "reduceRight")
  }

  val numbers: ParSeq[Int] = Range(1, 49990000, 1).map(_ * 3 / 5337).par

  def fold: Int = numbers.fold(0)(_ + _)

  def agg: Int = numbers.aggregate(0)(_ + _, _ + _)

  def foldLeft: Int = numbers.foldLeft(0)(_ + _)

  def foldRight: Int = numbers.foldRight(0)(_ + _)

  def reduce: Int = numbers.reduce(_ + _)

  def reduceLeft: Int = numbers.reduceLeft(_ + _)

  def reduceRight: Int = numbers.reduceRight(_ + _)
}

