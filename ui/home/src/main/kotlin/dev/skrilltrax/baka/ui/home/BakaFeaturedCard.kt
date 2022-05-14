package dev.skrilltrax.baka.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.skrilltrax.baka.data.model.common.Genre

@Composable
fun BakaFeaturedCard(
    title: String,
    imageUrl: String,
    containerColor: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor),
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            BakaFeaturedCardImage(
                url = imageUrl,
                containerColor = containerColor,
                modifier = modifier.weight(2f)
            )
            BakaFeaturedCardDetails(
                title = title,
                buttonText = "Add to List",
                genres = listOf(Genre.Action, Genre.Adventure),
                modifier.weight(3f)
            )
        }
    }
}

@Composable
fun BakaFeaturedCardImage(url: String, containerColor: Color, modifier: Modifier = Modifier) {
    val gradientBrush =
        remember(containerColor) {
            val startPoint = Pair(0.0f, containerColor.copy(alpha = 0.0f))
            val endPoint = Pair(1.0f, containerColor.copy(alpha = 1.0f))
            Brush.horizontalGradient(startPoint, endPoint)
        }

    AsyncImage(
        model = url,
        contentDescription = "Featured card image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .drawWithContent {
                drawContent()
                drawRect(gradientBrush)
            }
    )
}

@Suppress("UNUSED_PARAMETER")
@Composable
fun BakaFeaturedCardDetails(
    title: String,
    buttonText: String,
    genres: List<Genre>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxHeight().fillMaxWidth()) {
        Text(text = title)
        genres.forEach { Text(text = it.displayName) }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { /*TODO*/ }, shape = ) { Text(text = buttonText) }
            Icon(
                painter = rememberVectorPainter(image = Icons.Filled.ThumbUp),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewBakaFeaturedCard() {
    BakaFeaturedCard(
        title = "Shikimori's Not Just a Cutie",
        imageUrl = "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx127911-nKrY6sdaflPK.jpg",
        containerColor = Color(0xFF01C3D5),
        modifier = Modifier.size(600.dp, 200.dp)
    )
}
