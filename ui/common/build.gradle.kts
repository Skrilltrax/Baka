@file:Suppress("UnstableApiUsage")

plugins {
  id("dev.skrilltrax.baka.android-library")
  id("dev.skrilltrax.baka.kotlin-android")
}

android {
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compiler.get() }
  namespace = "dev.skrilltrax.baka.ui.common"
}

dependencies {
  implementation(libs.accompanist.insets)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.coil.kt.compose)

  debugImplementation(libs.compose.ui.tooling)
}
