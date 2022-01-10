plugins {
  id("dev.skrilltrax.baka.android-application")
  id("dev.skrilltrax.baka.kotlin-android")
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
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.core)
  implementation(libs.androidx.lifecycle.ktx)
  implementation(libs.compose.material)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling)
  implementation(libs.compose.activity)
  implementation(libs.material)
  testImplementation(libs.testing.junit)
  androidTestImplementation(libs.testing.junit.ext)
  androidTestImplementation(libs.testing.espresso.core)
  androidTestImplementation(libs.testing.junit.ui)
}
