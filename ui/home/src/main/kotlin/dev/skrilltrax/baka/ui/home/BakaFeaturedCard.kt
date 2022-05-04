package dev.skrilltrax.baka.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun BakaFeaturedCard(title: String, imageUrl: String, cardColor: Color) {
    Card(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), containerColor = cardColor) {
        Row {
            BakaFeaturedCardImage(
                url = imageUrl,
                overlayColor = cardColor,
                modifier = Modifier.fillMaxWidth(0.4f).testTag(title)
            )
        }
    }
}

@Composable
fun BakaFeaturedCardImage(url: String, overlayColor: Color, modifier: Modifier = Modifier) {
    val gradientBrush = remember(overlayColor) {
        val startPoint = Pair(0.0f, overlayColor.copy(alpha = 0.0f))
        val endPoint = Pair(1.0f, overlayColor.copy(alpha = 1.0f))
        Brush.horizontalGradient(startPoint, endPoint)
    }

    Box {
        AsyncImage(model = url,
            contentDescription = "Featured card image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .aspectRatio(0.85f) // 3:3.5
                .drawWithContent {
                    drawContent()
                    drawRect(gradientBrush)
                })
    }
}

@Preview
@Composable
fun PreviewBakaFeaturedCard() {
    BakaFeaturedCard(
        title = "Shikimori's Not Just a Cutie",
        imageUrl = "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx127911-nKrY6sdaflPK.jpg",
        cardColor = Color(0xFF01C3D5)
    )
}