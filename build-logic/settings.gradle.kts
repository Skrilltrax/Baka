@file:Suppress("UnstableApiUsage")

rootProject.name = "build-logic"

enableFeaturePreview("VERSION_CATALOGS")

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
  }
  versionCatalogs { create("libs") { from(files("../gradle/libs.versions.toml")) } }
}

include("android-plugins")

include("kotlin-plugins")

include("integration-plugins")
