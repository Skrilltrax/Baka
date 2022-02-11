package dev.skrilltrax.baka.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding

private val ContainerElevation = 3.0.dp

@Composable
fun BakaNavigationBar(items: List<String>, modifier: Modifier = Modifier) {
  val surfaceColor = MaterialTheme.colorScheme.surface
  var selectedItem by remember(items) { mutableStateOf(0) }

  Surface(modifier = modifier, color = surfaceColor, tonalElevation = ContainerElevation) {
    NavigationBar(modifier = modifier.navigationBarsPadding()) {
      items.forEachIndexed { index, item ->
        NavigationBarItem(
          icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
          label = { Text(item) },
          selected = selectedItem == index,
          onClick = { selectedItem = index }
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewBakaNavigationBar() {
  val items = listOf("Songs", "Artists", "Playlists")

  BakaNavigationBar(items)
}
