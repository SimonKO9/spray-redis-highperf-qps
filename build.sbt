name := "spray-redis-highperf-qps"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.0"
)


libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"

  Seq(
    "io.spray" %% "spray-can" % sprayV,
    "io.spray" %% "spray-routing" % sprayV,
    "io.spray" %% "spray-testkit" % sprayV % "test",
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    "org.specs2" %% "specs2-core" % "3.8.4"
  )
}