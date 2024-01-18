plugins {
  id("dev.skrilltrax.baka.android-library")
  id("dev.skrilltrax.baka.kotlin-android")
}

android {
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compiler.get() }
  namespace = "dev.skrilltrax.baka.ui.home"
}

dependencies {
  implementation(projects.ui.auth)
  implementation(projects.ui.common)

  implementation(libs.androidx.navigation.compose)
  implementation(libs.accompanist.insets)
  implementation(libs.accompanist.insets)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui.tooling.preview)

  debugImplementation(libs.compose.ui.tooling)
}
