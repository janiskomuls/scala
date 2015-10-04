package com.excentriq.learning

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.Random

object Futures extends App {

  println(s"program started on thread [$threadId]")
  println("before future")
  val future = Future {
    computationWhichMayFail("future 1", 500 milliseconds, willFailAnyWay = false)
  } fallbackTo {
    // will compute future anyway (will start to compute even before future 1)
    Future(computationWhichMayFail("future 2", 300 milliseconds, willFailAnyWay = false))
  } recoverWith {
    // will compute only if both futures will fail
    case e => Future(computationWhichMayFail("future 3", 100 milliseconds, willFailAnyWay = false))
  } map { value => // map from one of successful futures
    println(s"success result from: $value")
  } recover {
    case e => println(s"recover: ${e.getMessage}")
  }
  println("after future")

  // use only for testing purposes
  Await.result(future, 100 seconds)

  def threadId = Thread.currentThread().getId

  def computationWhichMayFail(name: String, time: Duration, willFailAnyWay: Boolean = false): String = {
    println(s"computation on thread [$threadId] start: $name")
    blocking(Thread.sleep(time.toMillis))
    val r = new Random()
    val rand: Int = r.nextInt()
    if (rand % 2 == 0 || willFailAnyWay) {
      println(s"computation end with error: $name")
      throw sys.error(s"error $name")
    } else {
      println(s"computation end: $name")
      name
    }
  }
}
