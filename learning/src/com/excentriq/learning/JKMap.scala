package com.excentriq.learning

class JKMap[K, V](val elems: Map[K, V]) extends (K => V) {
  override def apply(k: K): V = elems(k)
}
