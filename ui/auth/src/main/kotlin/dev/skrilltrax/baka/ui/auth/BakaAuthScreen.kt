package dev.skrilltrax.baka.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BakaAuthScreen() {
  Column(verticalArrangement = Arrangement.Center) {
    FilledTonalButton(onClick = {}) { Text(text = "Login") }
  }
}
