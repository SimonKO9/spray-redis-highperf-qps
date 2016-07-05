package com.github.simonthecat.highperfqps.redis

import com.redis.RedisClient

/**
  * Created by simon on 05.07.16.
  */
class WordService(client: RedisClient = DB.client) {

  def find(word: String): Option[String] = client.get[String](word).map(_ => word)
}
