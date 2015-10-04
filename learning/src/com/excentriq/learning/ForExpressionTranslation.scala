package com.excentriq.learning

object ForExpressionTranslation extends App {

  /**
   * example from https://class.coursera.org/reactive-002/ video lecture: Collections
   */
  val forUntil = for {
    i <- 1 until 5
    j <- 1 until i
    if (i + j) % 2 == 0
  } yield (i, j)

  val flatUntil = (1 until 5) flatMap (i =>
    (1 until i) withFilter (j => (i + j) % 2 == 0) map (j => (i, j))
    )
  println(forUntil)
  println(flatUntil)

  /**
   * JK example
   * mixing monads
   */
  val forSeq = for {
    i <- Seq(1, 2, 3, 5)
    j <- List(1, 2, 5, 7)
    if (i + j) % 2 == 0
    Wrap(f) <- Option(Wrap(s"abc$j")) // pattern matching
  } yield List(i, j, f)

  val flatSeq = Seq(1, 2, 3, 5)
    .flatMap(i => {
    List(1, 2, 5, 7)
      .withFilter(j => (i + j) % 2 == 0)
      .flatMap(j => {
      Option(Wrap(s"abc$j").s) // pattern matching not implemented here
        .map(f => List(i, j, f))
    })
  })
  println(forSeq)
  println(flatSeq)

  println(for(i <- Some(5)) yield i)

}

case class Wrap(s: String)
