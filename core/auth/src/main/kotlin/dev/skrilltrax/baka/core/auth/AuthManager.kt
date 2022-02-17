package dev.skrilltrax.baka.core.auth

import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.first

public class AuthManager(baseDir: String) {
  private val authDataStore: DataStore<Auth> by
    dataStore(baseDir = baseDir, fileName = FILE_NAME, serializer = AuthSerializer)

  public suspend fun getAuthToken(): Result<String> {
    return kotlin.runCatching { authDataStore.data.first().authToken }
  }

  public suspend fun saveAuthToken(token: String): Result<String> {
    authDataStore.updateData { currentAuth -> currentAuth.copy { authToken = token } }
    return kotlin.runCatching { authDataStore.data.first().authToken }
  }

  private companion object {
    private const val FILE_NAME = "auth.pb"
  }
}
