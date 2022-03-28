plugins {
  kotlin("jvm")
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.graphql")
  id("com.squareup.anvil") version "2.3.11-1-6-10"
}

anvil { generateDaggerFactories.set(true) }

dependencies {
  implementation(projects.core.auth)
  implementation(projects.di)

  implementation(libs.apollo.runtime)
  implementation(libs.apollo.cache.memory)
  implementation(libs.apollo.cache.sqlite)
  implementation(libs.dagger)
  implementation(libs.square.logging.interceptor)
}
