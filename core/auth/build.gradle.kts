plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("com.squareup.anvil") version "2.3.11-1-6-10"
}

anvil { generateDaggerFactories.set(true) }

dependencies {
  implementation(projects.core.util)
  implementation(projects.di)

  implementation(libs.androidx.datastore.prefs.core)
  implementation(libs.dagger)
  api(libs.thirdparty.kotlin.result)

  testImplementation(libs.testing.kotlin)
  testImplementation(libs.testing.kotlin.coroutines)
  testImplementation(libs.testing.kotlin.junit)
}
