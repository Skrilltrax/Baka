// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  // binary compatibility plugin from composite build is broken atm
  // id("dev.skrilltrax.baka.kotlin-binary-compatibility")
  // TODO: Fix binary compatibility plugin from composite build
  id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.8.0"
  id("dev.skrilltrax.baka.dependency-analysis")
  id("dev.skrilltrax.baka.kotlin-common")
  id("dev.skrilltrax.baka.kotlin-spotless")
}
