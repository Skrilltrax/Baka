@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka.ui.common.decorations

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import dev.skrilltrax.baka.ui.common.BakaAppBar

@Composable
fun BakaScaffold(
  title: String,
  modifier: Modifier = Modifier,
  content: @Composable (PaddingValues) -> Unit
) {
  val decayAnimationSpec = rememberSplineBasedDecay<Float>()
  val scrollBehavior =
    remember(decayAnimationSpec) {
      TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }

  Scaffold(
    modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { BakaAppBar(title = title, scrollBehavior = scrollBehavior) },
    bottomBar = { BakaNavigationBar(listOf("Temp", "Temp2", "Temp3")) },
    content = content,
  )
}
