import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { `kotlin-dsl` }

afterEvaluate {
  tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = JavaVersion.VERSION_19.toString()
    targetCompatibility = JavaVersion.VERSION_19.toString()
  }

  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = JavaVersion.VERSION_19.toString() }
  }
}

dependencies {
  implementation(libs.build.kotlin)
  implementation(libs.build.dependencyanalysis)
  implementation(libs.build.apollo.graphql)
  implementation(libs.build.anvil)
}
