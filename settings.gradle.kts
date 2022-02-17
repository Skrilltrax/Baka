@file:Suppress("UnstableApiUsage")

pluginManagement {
  repositories {
    includeBuild("build-logic")
    mavenCentral()
    google()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    google()
  }
}

rootProject.name = "Baka"

// experimental features
enableFeaturePreview("VERSION_CATALOGS")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:auth")

include(":core:network")

include(":ui:common")

include(":ui:home")
