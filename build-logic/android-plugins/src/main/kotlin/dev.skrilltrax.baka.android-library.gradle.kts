plugins {
  id("com.android.library")
  id("dev.skrilltrax.baka.android-common")
}

@Suppress("UnstableApiUsage")
android {
  buildTypes {
    debug { isMinifyEnabled = false }
    release { isMinifyEnabled = false }
  }
}
