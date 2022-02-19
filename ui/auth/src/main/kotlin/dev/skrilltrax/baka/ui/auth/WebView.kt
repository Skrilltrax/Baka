package dev.skrilltrax.baka.ui.auth

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebView(url: String, modifier: Modifier = Modifier) {
  AndroidView(
    modifier = modifier,
    factory = { context -> WebView(context) },
    update = { webView -> webView.loadUrl(url) }
  )
}
