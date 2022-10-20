plugins {
  id("dev.skrilltrax.baka.android-application")
  id("dev.skrilltrax.baka.kotlin-android")
  id("dev.skrilltrax.baka.secrets-plugin")
  id("com.squareup.anvil") version "2.4.2"
  id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
  kotlin("kapt")
}

android {
  defaultConfig {
    applicationId = "dev.skrilltrax.baka"
    versionCode = 1
    versionName = "0.1.0"
  }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = libs.versions.compiler.get() }
}

secrets {
  // Change the properties file from the default "local.properties" in your root project
  // to another properties file in your root project.
  propertiesFileName = "secrets.properties"

  // A properties file containing default secret values. This file can be checked in version
  // control.
  defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
  implementation(projects.core.auth)
  implementation(projects.core.network)
  implementation(projects.data.repository)
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

  // https://github.com/google/dagger/releases/tag/dagger-2.41
  // https://github.com/google/dagger/issues/3262
  implementation(libs.square.logging.interceptor)
  implementation(libs.apollo.runtime)
  implementation(libs.apollo.cache.memory)
  // implementation(libs.apollo.cache.sqlite)

  debugImplementation(libs.compose.ui.tooling)
  debugImplementation(libs.thirdparty.leakcanary)

  testImplementation(libs.testing.junit)

  androidTestImplementation(libs.testing.espresso.core)
  androidTestImplementation(libs.testing.junit.ui)
  androidTestImplementation(libs.testing.junit.ext)

  kapt(libs.dagger.compiler)
}
