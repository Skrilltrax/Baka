package dev.skrilltrax.baka

object Constants {
  const val ACCESS_TOKEN = "access_token"
  const val AUTH_URL =
    "https://anilist.co/api/v2/oauth/authorize?client_id=${BuildConfig.BAKA_CLIENT_ID}&response_type=token"
  const val REDIRECT_URI = "baka://auth"
}
