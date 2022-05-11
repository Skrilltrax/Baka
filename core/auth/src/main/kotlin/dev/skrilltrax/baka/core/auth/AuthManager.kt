package dev.skrilltrax.baka.core.auth

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.github.michaelbull.result.Result
import dev.skrilltrax.baka.core.util.extension.runSuspendCatching
import dev.skrilltrax.baka.core.util.extension.runSuspendCatchingWithContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

@Singleton
public class AuthManager @Inject constructor(@Named("InternalFilesDirPath") filesDir: String) {
  private val authDataStore by preferencesDataStore(filesDir, DATASTORE_NAME)

  public suspend fun getAuthToken(): Result<String, Throwable> = runSuspendCatchingWithContext(Dispatchers.IO) {
      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)
      val authToken = authDataStore.data.map { store -> store[authTokenKey] }

      authToken.firstOrNull() ?: throw AuthTokenNotFoundException()
    }

  public suspend fun saveAuthToken(authToken: String): Result<String, Throwable> {
    return runSuspendCatching {
      require(authToken.isNotEmpty()) { "authToken cannot be empty" }

      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)
      authDataStore.edit { store -> store[authTokenKey] = authToken }

      authToken
    }
  }

  public suspend fun removeAuthToken(): Result<Unit, Throwable> {
    return runSuspendCatching {
      val authTokenKey = stringPreferencesKey(AUTH_TOKEN_KEY)

      authDataStore.edit { store -> store.remove(authTokenKey) }
    }
  }

  private companion object {
    private const val DATASTORE_NAME = "auth"
    private const val AUTH_TOKEN_KEY = "auth_token"
  }
}
