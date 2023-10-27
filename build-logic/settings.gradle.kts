@file:Suppress("UnstableApiUsage")

rootProject.name = "build-logic"

pluginManagement {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven("https://storage.googleapis.com/r8-releases/raw/main")
  }
  versionCatalogs { create("libs") { from(files("../gradle/libs.versions.toml")) } }
}

include("android-plugins")

include("kotlin-plugins")

include("integration-plugins")
