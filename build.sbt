name := "BitcoinAnalyzer"

version := "0.1"

scalaVersion := "2.13.0"

enablePlugins(AssemblyPlugin)
// https://mvnrepository.com/artifact/commons-io/commons-io
libraryDependencies += "commons-io" % "commons-io" % "2.5"

// https://mvnrepository.com/artifact/org.json/json
libraryDependencies += "org.json" % "json" % "20180813"


// https://mvnrepository.com/artifact/org.apache.clerezza.ext/org.json.simple
libraryDependencies += "org.apache.clerezza.ext" % "org.json.simple" % "0.4"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.7.2"

