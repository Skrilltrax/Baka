package dev.skrilltrax.baka.ui.auth

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BakaAuthTitleText(text: String, modifier: Modifier = Modifier) {
  val titleStyle = MaterialTheme.typography.displayLarge
  Text(text = text, modifier = modifier, style = titleStyle)
}

@Composable
fun BakaAuthSubtitleText(text: String, modifier: Modifier = Modifier) {
  val titleStyle = MaterialTheme.typography.titleLarge
  Text(text = text, modifier = modifier, style = titleStyle)
}

@Composable
fun BakaAuthLabelText(text: String, modifier: Modifier = Modifier) {
  val titleStyle = MaterialTheme.typography.bodySmall
  Text(text = text, modifier = modifier, style = titleStyle)
}

@Preview
@Composable
fun PreviewBakaAuthTitleText() {
  BakaAuthLabelText(text = "ばか!!")
}

@Preview
@Composable
fun PreviewBakaAuthSubtitleText() {
  BakaAuthLabelText(text = "B-baka! You should login!")
}

@Preview
@Composable
fun PreviewBakaAuthLabelText() {
  BakaAuthLabelText(text = "It's not like I like you or anything...")
}
