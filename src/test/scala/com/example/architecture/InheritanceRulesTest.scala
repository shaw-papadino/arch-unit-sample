package com.example.architecture

import com.example.traits.MyImportantTrait
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class InheritanceRulesTest extends AnyFlatSpec with Matchers {

  // スキャン対象のパッケージ (実際のプロジェクトに合わせてください)
  val targetPackageName = "com.example.targets"
  // MyImportantTrait が含まれるパッケージもスキャン対象に含める
  val traitsPackageName = "com.example.traits"

  val importedClasses = new ClassFileImporter()
    .withImportOption(new com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests()) // テストコード自体を除外
    .withImportOption(new com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeJars()) // JARを除外 (必要に応じて)
    .importPackages(targetPackageName, traitsPackageName)
  println(s"global ${importedClasses.size()}, ${importedClasses.get("com.example.targets.CompliantClass")}")
  it should "MyImportantTrait を継承していること" in {
    println(s"in ${importedClasses.size()}, ${importedClasses.get("com.example.targets.CompliantClass")}")

    val rule = classes()
      .that()
      .resideInAPackage(targetPackageName) // 対象パッケージを指定
      .and()
      .areNotInterfaces()

      .should()
      .beAssignableTo(classOf[MyImportantTrait]) // MyImportantTrait型に代入可能であること
      .because(s"'$targetPackageName' 内のすべての具象クラスは MyImportantTrait を実装する必要があります。")

    // ルールのチェックを実行します。
    // 違反があった場合、ArchUnitは AssertionError (Java標準) をスローします。
    // ScalaTestはこの AssertionError を検知し、テスト失敗として扱います。
    rule.check(importedClasses)
  }
}
