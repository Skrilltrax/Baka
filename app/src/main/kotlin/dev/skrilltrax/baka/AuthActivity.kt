package dev.skrilltrax.baka

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.skrilltrax.baka.ui.auth.WebView

class AuthActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val aniListUrl =
      "https://anilist.co/api/v2/oauth/authorize?client_id=${BuildConfig.BAKA_CLIENT_ID}&response_type=token"
    setContent { WebView(url = aniListUrl) }
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)

    if (intent == null) {
      setResult(RESULT_CANCELED)
      finish()
      return
    }

    val uri = intent.data
    val returnIntent = Intent().apply { data = intent.data }

    if (uri.toString().startsWith(REDIRECT_URI)) {
      setResult(RESULT_OK, returnIntent)
    } else {
      setResult(RESULT_CANCELED, returnIntent)
    }

    finish()
  }

  companion object {
    private const val REDIRECT_URI = "baka://auth"
  }
}
