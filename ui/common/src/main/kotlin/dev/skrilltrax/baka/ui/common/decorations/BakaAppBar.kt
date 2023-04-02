@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka.ui.common.decorations

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun BakaAppBar(
  title: String,
  modifier: Modifier = Modifier,
) {
  TopAppBar(
    title = { Text(text = title) },
    modifier = modifier.statusBarsPadding(),
    windowInsets = WindowInsets.statusBars,
  )
}

@Preview
@Composable
fun PreviewBakaAppBar() {
  BakaAppBar("Anime", modifier = Modifier)
}
