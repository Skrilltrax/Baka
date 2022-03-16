package dev.skrilltrax.baka.ui.common.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import dev.skrilltrax.baka.ui.common.icons.filled.AccountCircle
import dev.skrilltrax.baka.ui.common.icons.filled.Book
import dev.skrilltrax.baka.ui.common.icons.filled.Forum
import dev.skrilltrax.baka.ui.common.icons.filled.Search
import dev.skrilltrax.baka.ui.common.icons.filled.SmartDisplay
import dev.skrilltrax.baka.ui.common.icons.outlined.AccountCircle
import dev.skrilltrax.baka.ui.common.icons.outlined.Book
import dev.skrilltrax.baka.ui.common.icons.outlined.Forum
import dev.skrilltrax.baka.ui.common.icons.outlined.Search
import dev.skrilltrax.baka.ui.common.icons.outlined.SmartDisplay

public enum class BakaDestination(
  public val displayName: String,
  public val uncheckedIcon: ImageVector,
  public val checkedIcon: ImageVector,
) {
  Anime("Anime", Icons.Outlined.SmartDisplay, Icons.Filled.SmartDisplay),
  Manga("Manga", Icons.Outlined.Book, Icons.Filled.Book),
  Search("Search", Icons.Outlined.Search, Icons.Filled.Search),
  Forum("Forum", Icons.Outlined.Forum, Icons.Filled.Forum),
  Profile("Profile", Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle),
  ;

  companion object {
    val startDestination = Anime
  }
}
