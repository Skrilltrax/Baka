package dev.skrilltrax.baka.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun BakaAuthBackground(imagePainter: Painter, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier,
        )
        Box(modifier = modifier.background(Color.Black.copy(alpha = 0.6f)))
    }
}
