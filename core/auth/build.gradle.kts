plugins {
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.protobuf")
}

dependencies {
  implementation(libs.androidx.datastore.core)
  implementation(libs.protobuf.java.lite)
}
