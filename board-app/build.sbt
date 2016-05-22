name := "board"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-orm" % "2.1.1",
  "org.mariadb.jdbc" % "mariadb-java-client" % "1.4.5",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)
