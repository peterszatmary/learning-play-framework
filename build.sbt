import sbt.Keys._

name := """LunchIn"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  //javaJdbc,
  cache,
  javaWs,
  "com.impetus.client" % "kundera-mongo" % "2.9",
  "org.mockito" % "mockito-all" % "1.9.5",
  //,
  //"junit" % "junit" % "4.11"
  filters,
  // bigpipe support :  (note, this project requires Play 2.4, Scala 2.11.6, SBT 0.13.8, and Java 8):
  "com.ybrikman.ping" %% "big-pipe" % "0.0.12"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically. (StaticRoutesGenerator)
routesGenerator := InjectedRoutesGenerator


// malo vyriesit problem s object api is not a member of package controllers.play
//sourceDirectories in (Compile, TwirlKeys.compileTemplates) := (unmanagedSourceDirectories in Compile).value
// malo pomoct s testami = ye nevidel foundation , nepomohlo
unmanagedResourceDirectories in Test <+= baseDirectory ( _ /"target/web/public/test" )



// adding new repositories
resolvers += "Kundera" at "https://oss.sonatype.org/content/repositories/releases"
resolvers += "Riptano" at "http://mvn.riptano.com/content/repositories/public"
resolvers += "Kundera missing" at "http://kundera.googlecode.com/svn/maven2/maven-missing-resources"
resolvers += "Scale 7" at "https://github.com/s7/mvnrepo/raw/master"


// Next, add support for the .scala.stream template type and some imports for it to your build:
TwirlKeys.templateFormats ++= Map("stream" -> "com.ybrikman.ping.scalaapi.bigpipe.HtmlStreamFormat")
TwirlKeys.templateImports ++= Vector("com.ybrikman.ping.scalaapi.bigpipe.HtmlStream", "com.ybrikman.ping.scalaapi.bigpipe._")



