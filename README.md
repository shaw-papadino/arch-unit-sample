## ArchUnit Sample

### テスト例

```sbt
sbt test
copying runtime jar...
[info] welcome to sbt 1.10.11 (Oracle Corporation Java 17.0.2)
[info] loading project definition from /Users/shoya.okayama.2/Repositories/arch-unit-sample/project
[info] loading settings for project root from build.sbt...
[info] set current project to arch-unit-sample (in build file:/Users/shoya.okayama.2/Repositories/arch-unit-sample/)
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
global 3, JavaClass{name='com.example.targets.CompliantClass'}
in 3, JavaClass{name='com.example.targets.CompliantClass'}
[info] InheritanceRulesTest:
[info] - should MyImportantTrait を継承していること *** FAILED ***
[info]   java.lang.AssertionError: Architecture Violation [Priority: MEDIUM] - Rule 'classes that reside in a package 'com.example.targets' and are not interfaces should be assignable to com.example.traits.MyImportantTrait, because 'com.example.targets' 内のすべての具象クラスは MyImportantTrait を実装する必要があります。' was violated (1 times):
[info] Class <com.example.targets.NonCompliantClass> is not assignable to com.example.traits.MyImportantTrait in (NonCompliantClass.scala:0)
[info]   at com.tngtech.archunit.lang.ArchRule$Assertions.assertNoViolation(ArchRule.java:94)
[info]   at com.tngtech.archunit.lang.ArchRule$Assertions.check(ArchRule.java:86)
[info]   at com.tngtech.archunit.lang.ArchRule$Factory$SimpleArchRule.check(ArchRule.java:165)
[info]   at com.example.architecture.InheritanceRulesTest.testFun$proxy1$1(InheritanceRulesTest.scala:37)
[info]   at com.example.architecture.InheritanceRulesTest.$init$$$anonfun$1(InheritanceRulesTest.scala:21)
[info]   at org.scalatest.Transformer.apply$$anonfun$1(Transformer.scala:22)
[info]   at org.scalatest.OutcomeOf.outcomeOf(OutcomeOf.scala:85)
[info]   at org.scalatest.OutcomeOf.outcomeOf$(OutcomeOf.scala:31)
[info]   at org.scalatest.OutcomeOf$.outcomeOf(OutcomeOf.scala:104)
[info]   at org.scalatest.Transformer.apply(Transformer.scala:22)
[info]   ...
[info] Run completed in 341 milliseconds.
[info] Total number of tests run: 1
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 0, failed 1, canceled 0, ignored 0, pending 0
[info] *** 1 TEST FAILED ***
[error] Failed tests:
[error] 	com.example.architecture.InheritanceRulesTest
[error] (Test / test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 1 s, completed 2025/05/07 19:10:52
```