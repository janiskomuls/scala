package com.excentriq.learning

object ForLoopTranslation extends App {

  println("for-loop:")
  for (i <- 1 until 3; j <- "abc") println(s"$i :: $j")

  println("translated to foreach:")
  1 until 3 foreach (i => "abc" foreach (j => println(s"$i :: $j")))
}
