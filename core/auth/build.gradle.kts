plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.protobuf")
}

dependencies {
  implementation(projects.core.util)

  implementation(libs.androidx.datastore.core)
  implementation(libs.protobuf.java.lite)
}
