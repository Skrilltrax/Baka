package dev.skrilltrax.baka.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.skrilltrax.baka.Constants
import dev.skrilltrax.baka.ui.auth.BakaAuthScreen
import dev.skrilltrax.baka.ui.common.decorations.BakaScaffold
import dev.skrilltrax.baka.ui.common.theme.BakaTheme

@Composable
fun BakaApp(isDarkTheme: Boolean) {
  BakaTheme(isDarkTheme) {
    ProvideWindowInsets {
      val context = LocalContext.current
      val systemUiController = rememberSystemUiController()
      val darkIcons = !isDarkTheme

      SideEffect { systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons) }

      BakaScaffold(
        title = "Anime",
        content = {
          BakaAuthScreen(
            onClick = {
              context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.AUTH_URL)))
            },
            modifier = Modifier.padding(it),
          )
        }
      )
    }
  }
}
