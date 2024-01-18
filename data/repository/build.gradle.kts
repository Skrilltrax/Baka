plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.anvil")
}

dependencies {
  implementation(projects.core.network)
  implementation(projects.di)

  implementation(libs.androidx.datastore.prefs.core)
  implementation(libs.apollo.runtime)
  implementation(libs.dagger)
  implementation(libs.thirdparty.kotlin.result)
}
