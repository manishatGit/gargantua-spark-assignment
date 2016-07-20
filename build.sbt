name := "gargantua-spark-assignment"

version := "1.0"

val spark = "org.apache.spark" % "spark-core_2.10" % "1.6.0"
val configuration = ""

lazy val commonSettings = Seq(
  organization := "com.knoldus",
  version := "0.1.0",
  scalaVersion := "2.10.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "gargantua_spark_assignment",
    libraryDependencies ++= Seq(spark)
  )
