@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.github.michaelbull.result.unwrap
import dev.skrilltrax.baka.core.auth.AuthManager
import dev.skrilltrax.baka.ui.BakaApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
  // TODO: Get this from DI instead
  private val authManager by lazy(LazyThreadSafetyMode.NONE) { AuthManager(filesDir.absolutePath) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent { BakaApp(isDarkTheme = isSystemInDarkTheme()) }
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    if (intent == null) {
      setResult(RESULT_CANCELED)
      finish()
      return
    }

    val uri = intent.data
    val stringUri = uri.toString()
    if (stringUri.startsWith(Constants.REDIRECT_URI) && stringUri.contains(Constants.ACCESS_TOKEN)
    ) {
      val parts = stringUri.split(Constants.ACCESS_TOKEN)
      val authToken = parts.last()
      lifecycleScope.launch(Dispatchers.IO) {
        authManager.saveAuthToken(authToken)
        withContext(Dispatchers.Main) {
          Toast.makeText(applicationContext, authManager.getAuthToken().unwrap(), Toast.LENGTH_LONG)
            .show()
        }
      }
    }
  }
}

@Preview(showBackground = true, group = "BakaApp", name = "Dark")
@Composable
fun PreviewBakaAppDarkTheme() {
  BakaApp(isDarkTheme = true)
}

@Preview(showBackground = true, group = "BakaApp", name = "Light")
@Composable
fun PreviewBakaAppLightTheme() {
  BakaApp(isDarkTheme = false)
}
