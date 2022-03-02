plugins {
  id("dev.skrilltrax.baka.android-application")
  id("dev.skrilltrax.baka.kotlin-android")
  id("dev.skrilltrax.baka.secrets-plugin")
  id("com.squareup.anvil") version "2.3.11-1-6-10"
  kotlin("kapt")
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
  implementation(projects.core.auth)
  implementation(projects.di)
  implementation(projects.ui.auth)
  implementation(projects.ui.common)
  implementation(projects.ui.home)

  implementation(libs.accompanist.insets)
  implementation(libs.accompanist.systemui)
  implementation(libs.androidx.core)
  implementation(libs.androidx.lifecycle.ktx)
  implementation(libs.compose.activity)
  implementation(libs.compose.material3)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.dagger)
  implementation(libs.thirdparty.kotlin.result)

  debugImplementation(libs.compose.ui.tooling)

  testImplementation(libs.testing.junit)

  androidTestImplementation(libs.testing.espresso.core)
  androidTestImplementation(libs.testing.junit.ui)
  androidTestImplementation(libs.testing.junit.ext)

  kapt(libs.dagger.compiler)
}
