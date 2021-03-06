// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Maven repository" at "http://mvnrepository.com/artifact/net.sf.flexjson/"

resolvers += "Maven repository" at "http://mvnrepository.com/artifact/com.googlecode.lambdaj/"

resolvers += "Maven repository 2" at "http://repo1.maven.org/maven2/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.0.4")