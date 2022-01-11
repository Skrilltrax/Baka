package dev.skrilltrax.baka.core.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory

public class ApolloClientBuilder {
  // Using lateinit property here because otherwise the compiler will complain that the property is
  // mutable
  private lateinit var memoryCacheFactory: MemoryCacheFactory
  private lateinit var sqlNormalizedCacheFactory: SqlNormalizedCacheFactory

  public fun useSQLCache(
    sqlNormalizedCacheFactory: SqlNormalizedCacheFactory
  ): ApolloClientBuilder {
    this.sqlNormalizedCacheFactory = sqlNormalizedCacheFactory
    return this
  }

  public fun useInMemoryCache(memoryCacheFactory: MemoryCacheFactory): ApolloClientBuilder {
    this.memoryCacheFactory = memoryCacheFactory
    return this
  }

  public fun build(): ApolloClient {
    val apolloClientBuilder = ApolloClient.Builder()
    // TODO: add test logging interceptor here?

    val isMemoryCacheInitialized = this::memoryCacheFactory.isInitialized
    val isSqlCacheInitialized = this::sqlNormalizedCacheFactory.isInitialized

    when {
      isMemoryCacheInitialized && isSqlCacheInitialized -> {
        val chainedCacheFactory = memoryCacheFactory.chain(sqlNormalizedCacheFactory)
        apolloClientBuilder.normalizedCache(chainedCacheFactory)
      }
      isMemoryCacheInitialized -> {
        apolloClientBuilder.normalizedCache(memoryCacheFactory)
      }
      isSqlCacheInitialized -> {
        apolloClientBuilder.normalizedCache(sqlNormalizedCacheFactory)
      }
      else -> {}
    }

    return apolloClientBuilder.build()
  }
}
