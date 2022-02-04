plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.graphql")
}

dependencies {
  implementation(libs.apollo.runtime)
  implementation(libs.apollo.cache.memory)
  implementation(libs.apollo.cache.sqlite)
}
