package dev.skrilltrax.baka.core.auth

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.unwrap
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

public class AuthManagerTest {
  private companion object {
    private const val TOKEN_DIR = "tokenDir"
    private const val SAMPLE_TOKEN = "SAMPLE_TOKEN"
    private val authManager = AuthManager(TOKEN_DIR)
  }

  @Test
  public fun `saves an auth token`() {
    runBlocking {
      val result = authManager.saveAuthToken(SAMPLE_TOKEN)
      assertTrue(result is Ok, "Token should be saved successfully")
      assertEquals(SAMPLE_TOKEN, result.unwrap(), "Returned token should be equal to $SAMPLE_TOKEN")
    }
  }

  @Test
  public fun `retrieves a saved auth token`() {
    runBlocking {
      val result = authManager.saveAuthToken(SAMPLE_TOKEN)
      assertTrue(result is Ok)
      assertEquals(SAMPLE_TOKEN, result.unwrap(), "Returned token should be equal to $SAMPLE_TOKEN")

      val saved = authManager.getAuthToken()
      assertTrue(saved is Ok, "Token should be fetched successfully")
      assertEquals(SAMPLE_TOKEN, saved.unwrap(), "Returned token should be equal to $SAMPLE_TOKEN")
    }
  }

  @Test
  public fun `deletes a saved token`() {
    runBlocking {
      val result = authManager.saveAuthToken(SAMPLE_TOKEN)
      assertTrue(result is Ok)
      assertEquals(SAMPLE_TOKEN, result.unwrap(), "Returned token should be equal to $SAMPLE_TOKEN")

      val deleted = authManager.removeAuthToken()
      assertTrue(deleted is Ok, "Token should be removed successfully")

      val saved = authManager.getAuthToken()
      assertTrue(saved is Err, "Removed token should not be accessible")
    }
  }
}
