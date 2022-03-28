package dev.skrilltrax.baka.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.network.okHttpClient
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.skrilltrax.baka.core.network.AuthorizationInterceptor
import dev.skrilltrax.baka.di.qualifier.BaseUrl
import dev.skrilltrax.baka.di.qualifier.MemoryCacheExpireTime
import dev.skrilltrax.baka.di.qualifier.MemoryCacheSizeLimit
import dev.skrilltrax.baka.di.scopes.AppScope
import javax.inject.Singleton
import kotlin.time.Duration.Companion.minutes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
@ContributesTo(AppScope::class)
public object NetworkModule {

  @Provides
  @BaseUrl
  public fun provideBaseUrl(): String {
    return "https://graphql.anilist.co/"
  }

  @Provides
  public fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor =
      HttpLoggingInterceptor().apply {
        redactHeader("Authorization")
        redactHeader("Cookie")
      }

    return interceptor
  }

  @Provides
  @Singleton
  public fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
  }

  @Provides
  @MemoryCacheSizeLimit
  public fun provideMemoryCacheSizeLimit(): Int {
    // 50 Megabytes = 50 Kilobytes * 1000 = 50 bytes * 1000 * 1000
    return 50 * 1000 * 1000
  }

  @Provides
  @MemoryCacheExpireTime
  public fun provideMemoryCacheExpireTime(): Long {
    // Set the cache expiry time to 5 minutes
    return 5.minutes.inWholeMilliseconds
  }

  @Provides
  @Singleton
  public fun provideMemoryCacheFactory(
    @MemoryCacheSizeLimit maxSizeBytes: Int,
    @MemoryCacheExpireTime expireAfterMillis: Long
  ): MemoryCacheFactory {
    return MemoryCacheFactory(maxSizeBytes, expireAfterMillis)
  }

  @Provides
  @Singleton
  public fun provideApolloClient(
    okHttpClient: OkHttpClient,
    authorizationInterceptor: AuthorizationInterceptor,
    memoryCacheFactory: MemoryCacheFactory,
    @BaseUrl serverUrl: String,
  ): ApolloClient {
    return ApolloClient.Builder()
      .serverUrl(serverUrl)
      .normalizedCache(memoryCacheFactory)
      .okHttpClient(okHttpClient)
      .addHttpInterceptor(authorizationInterceptor)
      .build()
  }
}
