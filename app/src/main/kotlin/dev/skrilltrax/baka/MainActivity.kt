@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import dev.skrilltrax.baka.ui.BakaApp
import dev.skrilltrax.baka.ui.theme.BakaTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent { BakaApp(isDarkTheme = isSystemInDarkTheme()) }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  BakaTheme { BakaHomeScreen() }
}
