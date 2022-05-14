plugins {
  id("dev.skrilltrax.baka.android-library")
  id("dev.skrilltrax.baka.kotlin-android")
}

android {
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.get() }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions.freeCompilerArgs += "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
}

dependencies {
  implementation(projects.ui.common)
  implementation(projects.data.model)

  implementation(libs.accompanist.insets)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.coil.compose)

  debugImplementation(libs.compose.ui.tooling)

  // required to make preview work on library modules
  debugImplementation(libs.androidx.core.ktx)
  debugImplementation(libs.androidx.lifecycle.viewmodel.ktx)
  debugImplementation(libs.androidx.lifecycle.viewmodel.savedstate)
  debugImplementation(libs.androidx.customview)
  debugImplementation(libs.androidx.customview.poolingcontainer)
}
