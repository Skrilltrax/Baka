package dev.skrilltrax.baka.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun BakaHomeScreen() {
  LazyColumn { items(1) { BakaTitleRow(title = "CURRENTLY TRENDING") } }
}
