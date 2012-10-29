import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Sample.Extjs.Play.Mvc.SimpleCrud"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.21",
      "com.googlecode.lambdaj" % "lambdaj" % "2.3.3",
      "net.sf.flexjson" % "flexjson" % "2.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
