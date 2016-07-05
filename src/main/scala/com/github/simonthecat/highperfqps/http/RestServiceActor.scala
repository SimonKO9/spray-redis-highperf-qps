package com.github.simonthecat.highperfqps.http

import akka.pattern._
import com.github.simonthecat.highperfqps.redis.WordService
import spray.routing.HttpServiceActor

import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
/**
  * Created by simon on 05.07.16.
  */
class RestServiceActor extends HttpServiceActor {

  val wordService = new WordService()

  override def receive: Receive = runRoute(routes)

  val routes = path("words" / Segment) { word =>
    get {
      complete {
        wordService.find(word)
      }
    }
  } ~ path("shutdown") {
    complete {
      after(5.seconds, context.system.scheduler) {
        Future.successful {
          System.exit(0)
        }
      }

      "System going for shutdown"
    }
  }

}
