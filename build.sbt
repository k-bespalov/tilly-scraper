name := "tilly-scraper"

version := "0.1"

scalaVersion := "3.1.3"

val http4sVersion = "0.23.12"
val http4sJdkHttpClientVersion = "0.7.0"
val circeVersion = "0.14.2"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.http4s" %% "http4s-jdk-http-client" % http4sJdkHttpClientVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-literal" % circeVersion,
  "com.typesafe" % "config" % "1.4.2"
)

