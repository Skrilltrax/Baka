plugins { id("com.apollographql.apollo3") }

apollo {
  packageName.set("dev.skrilltrax.baka.core.network")
  service("service") { packageName.set("dev.skrilltrax.baka.core.network") }
}
