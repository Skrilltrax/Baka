package dev.skrilltrax.baka.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.skrilltrax.baka.ui.theme.BakaTheme

@Composable
fun BakaApp(isDarkTheme: Boolean) {
  BakaTheme(isDarkTheme) {
    ProvideWindowInsets {
      val systemUiController = rememberSystemUiController()
      val darkIcons = !isDarkTheme

      SideEffect { systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons) }
    }
  }
}
