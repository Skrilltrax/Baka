// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // dependency-analysis plugin cannot access classes from kotlin and android plugins
    // if they are not specified in root level build.gradle
    id("com.android.application") version "7.2.0-alpha06" apply false
    id("com.android.library") version "7.2.0-alpha06" apply false
    id("org.jetbrains.kotlin.android") version "1.6.0" apply false
    id("com.autonomousapps.dependency-analysis") version "0.79.0" apply true
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}