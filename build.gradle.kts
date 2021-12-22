// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // dependency-analysis plugin cannot access classes from kotlin and android plugins
    // if they are not specified in root level build.gradle
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.android") apply false
    id("com.autonomousapps.dependency-analysis") apply true
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}