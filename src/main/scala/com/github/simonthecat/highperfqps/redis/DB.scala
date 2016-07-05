package com.github.simonthecat.highperfqps.redis

import com.redis._

/**
  * Created by simon on 05.07.16.
  */
object DB {

  lazy val client = new RedisClient()

}
