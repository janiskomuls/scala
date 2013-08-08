package com.rssanalizier.util

import java.net.URL
import com.sun.syndication.feed.synd.SyndEntry
import com.sun.syndication.feed.synd.SyndFeed
import com.sun.syndication.io.SyndFeedInput
import com.sun.syndication.io.XmlReader

object RssParser {

  def main(args: Array[String]) {
    val url: URL = new URL("http://www.ss.lv/lv/real-estate/flats/riga/rss/");
    var reader: XmlReader = null;

    try {

      reader = new XmlReader(url);
      println(reader.getEncoding)
      val feed: SyndFeed = new SyndFeedInput().build(reader);
      System.out.println("Feed Title: " + feed.getAuthor());

      val it = feed.getEntries().iterator()
      while (it.hasNext) {
        val syndEntry: SyndEntry = it.next.asInstanceOf[SyndEntry]
        println(syndEntry.getDescription.getValue.contains("S\u0113rija"))
        println(syndEntry.getDescription.getValue);
      }

    } finally {
      if (reader != null)
        reader.close();
    }

  }
  /*
def a =  """
  Ā	\u0100
�?	\u0101
Č	\u010C
�?	\u010D
Ē	\u0112
ē	\u0113
Ģ	\u011E
ģ	\u0123
Ī	\u012A
ī	\u012B
Ķ	\u0136
ķ	\u0137
Ļ	\u013B
ļ	\u013C
Ņ	\u0145
ņ	\u0146
Ō	\u014C
�?	\u014D
Ŗ	\u0156
ŗ	\u0157
Š	\u0160
š	\u0161
Ū	\u016A
ū	\u016B
Ž	\u017D
ž	\u017E
  """*/
}