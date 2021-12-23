import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

plugins {
  id("com.android.application")
  id("dev.skrilltrax.baka.android-common")
}

fun Project.isSnapshot(): Boolean {
  with(project.providers) {
    val workflow = environmentVariable("GITHUB_WORKFLOW").forUseAtConfigurationTime()
    val snapshot = environmentVariable("SNAPSHOT").forUseAtConfigurationTime()
    return workflow.isPresent || snapshot.isPresent
  }
}

@Suppress("UnstableApiUsage")
extensions.configure<BaseAppModuleExtension> {
  val minifySwitch =
    project.providers.environmentVariable("DISABLE_MINIFY").forUseAtConfigurationTime()

  adbOptions.installOptions("--user 0")

  buildFeatures { buildConfig = true }

  buildTypes {
    named("release") {
      isMinifyEnabled = !minifySwitch.isPresent
      setProguardFiles(
        listOf(
          "proguard-android-optimize.txt",
          "proguard-rules.pro",
          "proguard-rules-missing-classes.pro",
        )
      )
      buildConfigField("boolean", "ENABLE_DEBUG_FEATURES", "${project.isSnapshot()}")
    }
    named("debug") {
      applicationIdSuffix = ".debug"
      versionNameSuffix = "-debug"
      isMinifyEnabled = false
      buildConfigField("boolean", "ENABLE_DEBUG_FEATURES", "true")
    }
  }
}
