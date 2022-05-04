package dev.skrilltrax.baka.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.github.michaelbull.result.Result
import dev.skrilltrax.baka.core.network.GetTrendingAnimeQuery
import dev.skrilltrax.baka.core.network.fragment.Media
import dev.skrilltrax.baka.core.util.extension.runSuspendCatching
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class AnimeRepository @Inject constructor(private val apolloClient: ApolloClient) {

  public suspend fun getTrendingAnime(
    page: Int = 1,
    perPage: Int = 20,
    showAdult: Boolean = false
  ): Result<List<Media>, Throwable> =
    withContext(Dispatchers.IO) {
      return@withContext runSuspendCatching {
        val response =
          apolloClient
            .query(GetTrendingAnimeQuery(page, perPage, Optional.Present(showAdult)))
            .execute()

        val page = response.dataAssertNoErrors.page ?: error("Empty Page Received")
        val mediaList = page.media ?: error("No Media Found")

        mediaList.mapNotNull { it?.media }
      }
    }
}
