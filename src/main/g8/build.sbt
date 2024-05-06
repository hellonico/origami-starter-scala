
scalaVersion := "2.13.1"

resolvers ++= Seq(
  "hellonico" at "https://repository.hellonico.info/repository/hellonico",
  "clojars" at "https://repo.clojars.org")

name := "hello-origami"
organization := "org.hellonico"
version := "1.2"

libraryDependencies ++= Seq("origami" % "origami" % "4.9.0-1", "origami" % "filters" % "1.45", "origami" % "sources" % "1.0.1" )

// f*** sbt can't read transitive deps
libraryDependencies += "org.jetbrains.kotlin" % "kotlin-stdlib" % "1.3.72"
libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "4.7.2"
libraryDependencies += "com.squareup.moshi" % "moshi" % "1.9.2"
libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.2.19"
libraryDependencies += "org.mozilla" % "rhino" % "1.7.12"
