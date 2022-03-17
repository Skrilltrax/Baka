package dev.skrilltrax.baka.ui.common.decorations

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import dev.skrilltrax.baka.ui.common.navigation.BakaDestination

private val ContainerElevation = 3.0.dp

@Composable
fun BakaNavigationBar(destinations: List<BakaDestination>, modifier: Modifier = Modifier) {
  val surfaceColor = MaterialTheme.colorScheme.surface
  var selectedItem by remember(destinations) { mutableStateOf(0) }

  Surface(modifier = modifier, color = surfaceColor, tonalElevation = ContainerElevation) {
    NavigationBar(modifier = modifier.navigationBarsPadding()) {
      destinations.forEachIndexed { index, destination ->
        val isSelected = selectedItem == index
        val vectorIcon = if (isSelected) destination.checkedIcon else destination.uncheckedIcon
        NavigationBarItem(
          icon = { Icon(imageVector = vectorIcon, contentDescription = null) },
          label = { Text(destination.displayName) },
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
  BakaNavigationBar(BakaDestination.values().toList())
}
