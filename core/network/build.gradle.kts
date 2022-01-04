plugins {
  kotlin("jvm")
  id("dev.skrilltrax.baka.kotlin-library")
  id("dev.skrilltrax.baka.graphql")
}

dependencies { implementation(libs.graphql.runtime) }
