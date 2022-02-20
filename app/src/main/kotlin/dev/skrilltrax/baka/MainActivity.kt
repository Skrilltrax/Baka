@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import dev.skrilltrax.baka.core.auth.AuthManager
import dev.skrilltrax.baka.ui.BakaApp
import dev.skrilltrax.baka.util.getParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    val uri = intent.data ?: return
    val stringUri = uri.toString()

    if (!stringUri.startsWith(Constants.REDIRECT_URI)) return
    val parameters = uri.getParameters()
    val authToken = parameters[Constants.ACCESS_TOKEN]
    if (!authToken.isNullOrEmpty()) {
      lifecycleScope.launch(Dispatchers.IO) {
        authManager.saveAuthToken(authToken)
        // TODO: Remove this println
        println(authToken)
      }
    } else {
      // TODO: Propagate an error from here
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
