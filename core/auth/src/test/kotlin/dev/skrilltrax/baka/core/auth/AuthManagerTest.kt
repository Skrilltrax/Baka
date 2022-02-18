package dev.skrilltrax.baka.core.auth

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.unwrap
import com.github.michaelbull.result.unwrapError
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder

@OptIn(ExperimentalCoroutinesApi::class)
internal class AuthManagerTest {
  @get:Rule var temporaryFolder = TemporaryFolder()
  private lateinit var authManager: AuthManager
  private val authToken = "SAMPLE_TOKEN"

  @Before
  fun setup() {
    temporaryFolder.create()
    authManager = AuthManager(temporaryFolder.root.absolutePath)
  }

  @Test
  fun `saves an auth token`() = runTest {
    val result = authManager.saveAuthToken(authToken)
    assertTrue(result is Ok, "Token should be saved successfully")
    assertEquals(authToken, result.unwrap(), "Returned token should be equal to $authToken")
  }

  @Test
  fun `saves an empty auth token`() = runTest {
    val result = authManager.saveAuthToken("")
    assertTrue(result is Err, "Removed token should not be accessible")
    assertIs<IllegalArgumentException>(result.unwrapError())
  }

  @Test
  fun `retrieves a saved auth token`() = runTest {
    val result = authManager.saveAuthToken(authToken)
    assertTrue(result is Ok)
    assertEquals(authToken, result.unwrap(), "Returned token should be equal to $authToken")

    val saved = authManager.getAuthToken()
    assertTrue(saved is Ok, "Token should be fetched successfully")
    assertEquals(authToken, saved.unwrap(), "Returned token should be equal to $authToken")
  }

  @Test
  fun `retrieve an auth token without saving`() = runTest {
    val result = authManager.getAuthToken()
    assertTrue(result is Err, "Removed token should not be accessible")
    assertIs<AuthTokenNotFoundException>(result.unwrapError())
  }

  @Test
  fun `deletes a saved token`() = runTest {
    val result = authManager.saveAuthToken(authToken)
    assertTrue(result is Ok)
    assertEquals(authToken, result.unwrap(), "Returned token should be equal to $authToken")

    val deleted = authManager.removeAuthToken()
    assertTrue(deleted is Ok, "Token should be removed successfully")

    val saved = authManager.getAuthToken()
    assertTrue(saved is Err, "Removed token should not be accessible")
    assertIs<AuthTokenNotFoundException>(saved.unwrapError())
  }
}
