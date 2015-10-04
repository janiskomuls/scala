package com.excentriq.learning

object PartialFunction extends App {

  val names = Map(("a", 1), ("b", 2), ("c", 3), (4, 4))

  Seq("a", "b", "c", "d", 3, 5) foreach {
    case key => println(s"$key :: " + value.isDefinedAt(key))
    case _ =>
  }

  def value: PartialFunction[Any, Int] = {
    case k: String => names(k)
  }
}