package com.rssanalizier.util

import java.util.HashMap

import org.codehaus.jackson.map.ObjectMapper

import net.liftweb.json.JsonAST.JObject
import net.liftweb.json.JsonParser
import com.wordnik.swagger.core.util.JsonUtil

object JsonUtils {

  def jsonToMap(json: String): Map[String, Any] = {
    try {
      val record = JsonParser.parse(json).asInstanceOf[JObject]
      record.values
    } catch {
      case e: Throwable => error(e.getMessage())
    }
  }

  def jsonToMap2(json: String): Map[String, Any] = {
    try {
      val objectMapper = JsonUtil.getJsonMapper
      objectMapper.readValue(json, classOf[Map[String, Any]])
    } catch {
      case er: Error => error(er.getMessage())
      case e: Exception => error(e.getMessage())
    }
  }

}