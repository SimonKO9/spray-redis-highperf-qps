package com.github.simonthecat.highperfqps.redis

import scala.io.Source

/**
  * Created by simon on 05.07.16.
  */
object Initializer {

  def fillDatabase() =
    Source.fromInputStream(getClass.getResourceAsStream("/en_us_dict.txt")).getLines()
      .dropWhile(line => line != "---")
      .take(1000)
      .foreach(word => {
        DB.client.set(word, 1)
      })

}
