import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("dev.skrilltrax.baka.kotlin-common")
  id("org.jetbrains.kotlinx.kover")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    if (!name.contains("test", ignoreCase = true)) {
      freeCompilerArgs += listOf("-Xexplicit-api=strict")
    }
  }
}

tasks.koverXmlReport {
  xmlReportFile.set(rootProject.layout.buildDirectory.file("coverage-reports/${project.name}.xml"))
}

tasks.koverHtmlReport {
  htmlReportDir.set(rootProject.layout.buildDirectory.dir("coverage-reports/${project.name}"))
}
