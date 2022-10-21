plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.anvil")
}

dependencies {
  implementation(projects.core.util)

  implementation(libs.androidx.datastore.prefs.core)
  implementation(libs.dagger)
  implementation(libs.thirdparty.kotlin.result)

  testImplementation(libs.testing.kotlin)
  testImplementation(libs.testing.kotlin.coroutines)
  testImplementation(libs.testing.kotlin.junit)
}
