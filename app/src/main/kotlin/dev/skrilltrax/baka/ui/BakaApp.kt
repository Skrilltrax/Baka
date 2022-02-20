package dev.skrilltrax.baka.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.skrilltrax.baka.AuthActivity
import dev.skrilltrax.baka.ui.auth.BakaAuthScreen
import dev.skrilltrax.baka.ui.common.decorations.BakaScaffold
import dev.skrilltrax.baka.ui.common.theme.BakaTheme

@Composable
fun BakaApp(isDarkTheme: Boolean) {
  BakaTheme(isDarkTheme) {
    ProvideWindowInsets {
      // TODO: Clean this up after handling navigation
      var code by remember { mutableStateOf("") }
      val context = LocalContext.current
      val loginNavigation =
        rememberLauncherForActivityResult(
          contract = ActivityResultContracts.StartActivityForResult(),
          onResult = {
            code = it.data?.dataString ?: "No Data"
            Toast.makeText(context, code, Toast.LENGTH_LONG).show()
          }
        )
      val systemUiController = rememberSystemUiController()
      val darkIcons = !isDarkTheme

      SideEffect { systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons) }

      BakaScaffold(
        title = "Anime",
        content = {
          BakaAuthScreen(
            onLogin = { loginNavigation.launch(Intent(context, AuthActivity::class.java)) },
            modifier = Modifier.padding(it),
          )
        }
      )
    }
  }
}
