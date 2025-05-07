ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "arch-unit-sample"
  )

val archUnitVersion = "1.4.0"
val junitVersion = "5.12.2"

libraryDependencies ++= Seq(
  // ArchUnit Core
  "com.tngtech.archunit" % "archunit" % archUnitVersion % Test,
  // ArchUnit と JUnit 5 の連携
  "com.tngtech.archunit" % "archunit-junit5" % archUnitVersion % Test,

  // JUnit 5 (テスト実行のため)
  "org.junit.jupiter" % "junit-jupiter-api" % junitVersion % Test,
  "org.junit.jupiter" % "junit-jupiter-engine" % junitVersion % Test,

  "org.scalatest" %% "scalatest" % "3.2.19" % Test
)