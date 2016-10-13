name := "spark-sql"
 
version := "1.0"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

scalaVersion := "2.11.8"
 
resolvers += "jitpack" at "https://jitpack.io"
 
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.0.0" % "provided",
  "mysql" % "mysql-connector-java" % "5.1.12"
)
