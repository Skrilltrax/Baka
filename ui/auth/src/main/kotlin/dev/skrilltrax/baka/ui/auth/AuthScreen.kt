package dev.skrilltrax.baka.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(modifier: Modifier = Modifier) {
    val painter = rememberImagePainter(
        data = R.drawable.hitagi_blurred,
        builder = { crossfade(true) }
    )

    Box(modifier = modifier.fillMaxSize()) {
        BakaAuthBackground(imagePainter = painter, modifier = modifier.fillMaxSize())
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BakaAuthTitleText(text = "ばか!!")
            Spacer(modifier = modifier.fillMaxWidth().height(24.dp))
            BakaAuthSubtitleText(text = "B-baka! You should login!")
            Spacer(modifier = modifier.fillMaxWidth().height(8.dp))
            BakaAuthLabelText(text = "It's not like I like you or anything...")
            Spacer(modifier = modifier.fillMaxWidth().height(24.dp))
            Button(onClick = { }, modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(text = "Login")
            }
        }
    }
}