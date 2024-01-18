@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka.ui.home

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.skrilltrax.baka.ui.auth.BakaAuthScreen
import dev.skrilltrax.baka.ui.common.decorations.BakaAppBar
import dev.skrilltrax.baka.ui.common.decorations.BakaNavigationBar
import dev.skrilltrax.baka.ui.common.navigation.BakaDestination

@Composable
fun BakaHomeScreen(
  authenticateUser: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val decayAnimationSpec = rememberSplineBasedDecay<Float>()
  val scrollBehavior =
    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(flingAnimationSpec = decayAnimationSpec)

  // Navigation
  val navController = rememberNavController()
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val navDestination = navBackStackEntry?.destination
  val currentDestination =
    remember(navDestination) { BakaDestination.fromDisplayName(navDestination?.route) }

  val navigateToDestination = { _: BakaDestination, newDestination: BakaDestination ->
    navController.navigate(newDestination.displayName) {
      popUpTo(navController.graph.findStartDestination().id) { saveState = true }
      launchSingleTop = true
      restoreState = true
    }
  }

  Scaffold(
    modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { BakaAppBar(title = currentDestination.displayName) },
    bottomBar = {
      BakaNavigationBar(
        destinations = BakaDestination.entries,
        currentDestination = currentDestination,
        onNavigation = navigateToDestination,
        modifier = modifier
      )
    },
    content = { innerPadding ->
      NavHost(
        navController = navController,
        startDestination = BakaDestination.startDestination.displayName,
        modifier = modifier.padding(innerPadding)
      ) {
        composable(BakaDestination.Anime.displayName) {}
        composable(BakaDestination.Manga.displayName) {}
        composable(BakaDestination.Search.displayName) {}
        composable(BakaDestination.Forum.displayName) {}
        composable(BakaDestination.Profile.displayName) {
          BakaAuthScreen(onClick = authenticateUser)
        }
      }
    }
  )
}
