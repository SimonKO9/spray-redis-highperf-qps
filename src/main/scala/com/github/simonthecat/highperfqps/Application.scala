package com.github.simonthecat.highperfqps

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import com.github.simonthecat.highperfqps.http.RestServiceActor
import com.github.simonthecat.highperfqps.redis.Initializer
import spray.can.Http

import scala.concurrent.duration._

/**
  * Created by simon on 05.07.16.
  */
object Application extends App {

  Initializer.fillDatabase()

  implicit val system = ActorSystem("highperfqps")
  val service = system.actorOf(Props[RestServiceActor], "http-service")
  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)

}
