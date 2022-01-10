plugins {
  id("dev.skrilltrax.baka.android-library")
  id("dev.skrilltrax.baka.kotlin-android")
  id("dev.skrilltrax.baka.kotlin-library")
}

android {
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.get() }
}

dependencies {
  implementation(libs.compose.compiler)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling)
  implementation(libs.compose.foundation)
  implementation(libs.compose.foundation.layout)
  implementation(libs.compose.material)
}
