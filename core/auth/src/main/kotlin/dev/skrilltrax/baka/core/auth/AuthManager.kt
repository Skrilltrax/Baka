package dev.skrilltrax.baka.core.auth

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.runCatching
import dev.skrilltrax.baka.di.scopes.AppScope
import dev.skrilltrax.baka.di.scopes.SingleInstanceIn
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
public class AuthManager @Inject constructor(@Named("InternalFilesDirPath") filesDir: String) {
  private val authDataStore by preferencesDataStore(filesDir, DATASTORE_NAME)

  public suspend fun getAuthToken(): Result<String, Throwable> {
    return runCatching {
      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)
      val authToken = authDataStore.data.map { store -> store[authTokenKey] }

      return@runCatching authToken.firstOrNull() ?: throw AuthTokenNotFoundException()
    }
  }

  public suspend fun saveAuthToken(authToken: String): Result<String, Throwable> {
    return runCatching {
      require(authToken.isNotEmpty()) { "authToken cannot be empty" }

      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)
      authDataStore.edit { store -> store[authTokenKey] = authToken }

      authToken
    }
  }

  public suspend fun removeAuthToken(): Result<Unit, Throwable> {
    return runCatching {
      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)

      authDataStore.edit { store -> store.remove(authTokenKey) }
    }
  }

  private companion object {
    private const val DATASTORE_NAME = "auth"
    private const val AUTH_TOKEN_KEY = "auth_token"
  }
}
