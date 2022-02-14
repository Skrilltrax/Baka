@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka.ui.common

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun BakaAppBar(
  title: String,
  scrollBehavior: TopAppBarScrollBehavior,
  modifier: Modifier = Modifier,
) {
  val colors = TopAppBarDefaults.largeTopAppBarColors()
  val scrollFraction = scrollBehavior.scrollFraction
  val appBarContainerColor by colors.containerColor(scrollFraction)

  // Wrapping in `Surface` because insets-ui is not available for material3 components
  Surface(modifier = modifier, color = appBarContainerColor) {
    SmallTopAppBar(
      title = { Text(text = title) },
      modifier = modifier.statusBarsPadding(),
      scrollBehavior = scrollBehavior,
    )
  }
}

@Preview
@Composable
fun PreviewBakaAppBar() {
  val decayAnimationSpec = rememberSplineBasedDecay<Float>()
  val scrollBehavior =
    remember(decayAnimationSpec) {
      TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }

  BakaAppBar("Anime", scrollBehavior, modifier = Modifier)
}
