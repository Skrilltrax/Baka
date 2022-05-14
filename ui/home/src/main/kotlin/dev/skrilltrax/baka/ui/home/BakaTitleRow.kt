package dev.skrilltrax.baka.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.skrilltrax.baka.ui.common.BakaThumbItem

@Preview
@Composable
fun BakaTitleRow(title: String = "CURRENTLY TRENDING") {
  Column(modifier = Modifier.padding(start = 16.dp)) {
    Text(text = title)
    LazyRow(
      modifier = Modifier.padding(top = 8.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(15) {
        BakaThumbItem(
          thumbUrl =
            "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx131681-ODIRpBIbR5Eu.jpg",
          desc = "Shingeki no Kyojin: The Final Season Part 2"
        )
      }
    }
  }
}
