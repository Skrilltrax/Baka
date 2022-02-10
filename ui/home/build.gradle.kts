plugins { id("dev.skrilltrax.baka.android-library") }

dependencies {
  implementation(libs.compose.material3)
  implementation(libs.compose.ui.tooling.preview)

  debugImplementation(libs.compose.ui.tooling)
}
