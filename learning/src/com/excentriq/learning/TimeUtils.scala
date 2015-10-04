package com.excentriq.learning

import java.lang.System.currentTimeMillis

object TimeUtils {
  def runAndTime(func: => Int, name: String): Unit = {
    val time = currentTimeMillis()
    println(s"$name :: $func :: time: ${currentTimeMillis() - time}")
  }

  def runAndTime(name: String, func: => Any): Unit = {
    val time = currentTimeMillis()
    func
    println(s"$name :: time: ${currentTimeMillis() - time}")
  }
}
