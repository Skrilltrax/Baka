import kotlinx.kover.tasks.KoverHtmlReportTask
import kotlinx.kover.tasks.KoverXmlReportTask
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
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

tasks.withType<KoverXmlReportTask>().configureEach {
    xmlReportFile.set(rootProject.layout.buildDirectory.file("coverage-reports/${project.name}.xml"))
}

tasks.withType<KoverHtmlReportTask>().configureEach {
    htmlReportDir.set(rootProject.layout.buildDirectory.dir("coverage-reports/${project.name}"))
}
