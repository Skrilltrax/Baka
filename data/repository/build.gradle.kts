plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("com.squareup.anvil") version "2.4.2"
}

anvil { generateDaggerFactories.set(true) }

dependencies {
  implementation(projects.core.network)
  implementation(projects.di)

  implementation(libs.androidx.datastore.prefs.core)
  implementation(libs.apollo.runtime)
  implementation(libs.dagger)
}
