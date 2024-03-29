@file:Suppress("UnstableApiUsage")

pluginManagement {
  repositories {
    includeBuild("build-logic")
    mavenCentral()
    google()
    gradlePluginPortal()
    maven("https://storage.googleapis.com/r8-releases/raw/main")
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
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:auth")

include(":core:network")

include(":core:util")

include(":data:model")

include(":data:repository")

include(":di")

include(":ui:auth")

include(":ui:common")

include(":ui:home")
