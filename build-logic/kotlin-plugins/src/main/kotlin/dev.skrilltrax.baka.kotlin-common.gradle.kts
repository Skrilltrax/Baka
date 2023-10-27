import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val additionalCompilerArgs =
  listOf(
    "-opt-in=kotlin.RequiresOptIn",
  )

tasks.withType<JavaCompile>().configureEach {
  sourceCompatibility = JavaVersion.VERSION_19.toString()
  targetCompatibility = JavaVersion.VERSION_19.toString()
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_19.toString()
    freeCompilerArgs = freeCompilerArgs + additionalCompilerArgs
    languageVersion = "1.9"
    allWarningsAsErrors = false
  }
}

tasks.withType<Test>().configureEach {
  maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
  testLogging { events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED) }
  doNotTrackState("We want tests to always run even if Gradle thinks otherwise")
}
