package com.excentriq.learning

import scala.util.{Failure, Success, Try}

object TrySuccessFailure extends App {

  case class Adventure(country: String) {
    val blacklisted = Seq("Columbia", "Mongolia", "Korea")

    def tryTo = Try {
      if (blacklisted contains country)
        throw sys.error("Dangerous country")
      else country
    }
  }

  println("Try examples:\n")

  /**
   * match with partial function + failure@Failure(_) pattern
   */
  def matchResult: PartialFunction[Try[String], Try[String]] = {
    case success@Success(country) => println(country); success
    case failure@Failure(e) => println(e); failure
  }

  println("Partial function with match:")
  matchResult(Adventure("Argentina") tryTo)
  matchResult(Adventure("Columbia") tryTo)

  /**
   * Monadic way (map/flatMap can be used as well)
   */
  println("\nMonadic way:")
  println(Adventure("Korea").tryTo getOrElse "Dangerous")
  println(Adventure("UK").tryTo getOrElse "Dangerous")

}
