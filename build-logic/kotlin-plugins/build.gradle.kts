import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { `kotlin-dsl` }

tasks.withType<JavaCompile>().configureEach {
  sourceCompatibility = JavaVersion.VERSION_11.toString()
  targetCompatibility = JavaVersion.VERSION_11.toString()
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_11.toString() }
}

dependencies {
  implementation(libs.build.agp)
  implementation(libs.build.binarycompat)
  implementation(libs.build.kover)
  implementation(libs.build.kotlin)
  implementation(libs.build.spotless)
}
