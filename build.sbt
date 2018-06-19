// The simplest possible sbt build file is just one line:

scalaVersion := "2.12.6"
name := "SatyaShoppingCart"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
    