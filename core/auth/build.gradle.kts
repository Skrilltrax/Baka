plugins { id("dev.skrilltrax.baka.kotlin-library") }

dependencies {
    implementation(projects.core.util)

    implementation(libs.androidx.datastore.prefs.core)
    implementation(libs.thirdparty.kotlin.result)
}
