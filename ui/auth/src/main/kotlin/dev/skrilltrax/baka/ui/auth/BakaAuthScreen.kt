package dev.skrilltrax.baka.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BakaAuthScreen(onClick: () -> Unit, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    BakaAuthTitleText(
      text = stringResource(R.string.baka_auth_login_title),
      modifier = Modifier.padding(16.dp)
    )
    BakaAuthSubtitleText(
      text = stringResource(R.string.baka_auth_login_subtitle),
      modifier = Modifier.padding(2.dp)
    )
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth(0.6f).padding(16.dp)) {
      Text(text = stringResource(R.string.login))
    }
  }
}
