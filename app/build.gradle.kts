plugins {
  id("dev.skrilltrax.baka.android-application")
  id("dev.skrilltrax.baka.kotlin-android")
  id("dev.skrilltrax.baka.secrets-plugin")
}

android {
  defaultConfig {
    applicationId = "dev.skrilltrax.baka"
    versionCode = 1
    versionName = "0.1.0"
  }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.get() }
}

dependencies {
  implementation(projects.ui.common)
  implementation(projects.ui.home)
  implementation(projects.ui.auth)

  implementation(libs.accompanist.insets)
  implementation(libs.accompanist.systemui)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core)
  implementation(libs.androidx.lifecycle.ktx)
  implementation(libs.compose.activity)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)

  debugImplementation(libs.compose.ui.tooling)

  testImplementation(libs.testing.junit)

  androidTestImplementation(libs.testing.espresso.core)
  androidTestImplementation(libs.testing.junit.ui)
  androidTestImplementation(libs.testing.junit.ext)
}
