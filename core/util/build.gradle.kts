plugins { id("dev.skrilltrax.baka.kotlin-library") }

dependencies {
  api(libs.thirdparty.kotlin.result)
  implementation(libs.androidx.datastore.prefs.core)
}
