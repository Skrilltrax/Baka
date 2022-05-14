@file:OptIn(ExperimentalMaterial3Api::class)

package dev.skrilltrax.baka.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun BakaThumbItem(thumbUrl: String, desc: String) {
  Column(modifier = Modifier.width(100.dp)) {
    Card(shape = RoundedCornerShape(8.dp)) {
      Box(modifier = Modifier.size(height = 128.dp, width = 96.dp)) {
        Image(
          painter =
            rememberAsyncImagePainter(
              ImageRequest.Builder(LocalContext.current)
                .data(data = thumbUrl)
                .apply(
                  block =
                    fun ImageRequest.Builder.() {
                      crossfade(true)
                    }
                )
                .build()
            ),
          contentDescription = desc,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop
        )
      }
    }
    Text(text = desc, maxLines = 2, overflow = TextOverflow.Ellipsis)
  }
}
