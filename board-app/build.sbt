name := "board"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-orm" % "2.1.1",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.5.+",
  "org.mariadb.jdbc" % "mariadb-java-client" % "1.4.5",
  // "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

// routesImport += "utils.Binders._"
routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)

// skinny.DBSettings.initialize()
initialCommands in console := """
import scalikejdbc._
import skinny.orm._, feature._
import org.joda.time._
Class.forName("org.mariadb.jdbc.Driver")
ConnectionPool.singleton("jdbc:mysql://localhost:3306/tmp_board", "root", "root")
implicit val session = AutoSession

import models._
"""
