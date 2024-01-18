package dev.skrilltrax.baka.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.skrilltrax.baka.Constants
import dev.skrilltrax.baka.ui.common.theme.BakaTheme
import dev.skrilltrax.baka.ui.home.BakaHomeScreen

@Composable
fun BakaApp(isDarkTheme: Boolean) {
  BakaTheme(isDarkTheme) {
    ProvideWindowInsets {
      val context = LocalContext.current
      val systemUiController = rememberSystemUiController()
      val darkIcons = !isDarkTheme
      val navController = rememberNavController()

      val authenticateUser = {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.AUTH_URL)))
      }

      SideEffect { systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = darkIcons) }

      NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { BakaHomeScreen(authenticateUser = authenticateUser) }
        composable("Detail") {}
      }
    }
  }
}
