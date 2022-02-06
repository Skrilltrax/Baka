package dev.skrilltrax.baka.ui.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
public fun BakaPrimaryButton(text: String, onClick: (() -> Unit)) {
  Button(onClick = onClick) { Text(text = text) }
}

@Preview
@Composable
private fun PreviewBakaPrimaryButton() {
  BakaPrimaryButton(text = "Continue Watching", onClick = {})
}
