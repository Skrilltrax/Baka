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

extensions.configure<kotlinx.kover.gradle.plugin.dsl.KoverReportExtension> {
  defaults {
    // reports configs for XML, HTML, verify reports
    html { setReportDir(rootProject.layout.buildDirectory.dir("coverage-reports/${project.name}")) }

    xml {
      setReportFile(rootProject.layout.buildDirectory.file("coverage-reports/${project.name}.xml"))
    }
  }
}
