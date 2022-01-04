import com.apollographql.apollo3.gradle.api.ApolloExtension

plugins { id("com.apollographql.apollo3") }

extensions.configure<ApolloExtension> { packageName.set("dev.skrilltrax.baka.core.network") }
