package dev.skrilltrax.baka.core.network

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.getOrThrow
import dev.skrilltrax.baka.core.auth.AuthManager
import javax.inject.Inject

public class AuthorizationInterceptor @Inject constructor(private val authManager: AuthManager) :
  HttpInterceptor {

  override suspend fun intercept(request: HttpRequest, chain: HttpInterceptorChain): HttpResponse {
    val tokenResult = authManager.getAuthToken()
    if (tokenResult is Err) {
      // TODO: Replace this with a logging library
      // Fork square's logcat and release it as a jar or add KMP support to it
      println("No auth token found")
      return chain.proceed(request)
    }

    // This will not throw because we have already that token result is not an error
    val token = tokenResult.getOrThrow()
    return chain.proceed(request.newBuilder().addHeader("Authorization", "Bearer $token").build())
  }
}
