plugins {
  id("dev.skrilltrax.baka.android-library")
  id("dev.skrilltrax.baka.kotlin-android")
}

android {
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.get() }
}

dependencies {
  implementation(projects.ui.common)

  implementation(libs.accompanist.insets)
  implementation(libs.androidx.core)
  implementation(libs.androidx.palette)
  implementation(libs.coil.kt.compose)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui.tooling.preview)

  debugImplementation(libs.compose.ui.tooling)
}
