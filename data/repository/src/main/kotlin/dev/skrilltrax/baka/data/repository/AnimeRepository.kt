package dev.skrilltrax.baka.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional.Companion.presentIfNotNull
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.toResultOr
import dev.skrilltrax.baka.core.network.GetAnimeListQuery
import dev.skrilltrax.baka.core.network.type.MediaSeason
import dev.skrilltrax.baka.core.network.type.MediaSort
import java.lang.Exception
import java.lang.IllegalStateException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class AnimeRepository @Inject constructor(private val apolloClient: ApolloClient) {

  public suspend fun getTrendingAnime(
    page: Int = 1,
    perPage: Int = 20,
    sort: List<MediaSort>? = null,
    season: MediaSeason? = null,
    seasonYear: Int? = null,
    showAdult: Boolean = false,
  ): Result<GetAnimeListQuery.Data, Exception> =
    withContext(Dispatchers.IO) {
      val response =
        apolloClient
          .query(
            GetAnimeListQuery(
              page = page,
              perPage = perPage,
              sort = presentIfNotNull(sort),
              season = presentIfNotNull(season),
              seasonYear = presentIfNotNull(seasonYear),
              showAdult = presentIfNotNull(showAdult)
            )
          )
          .execute()

      return@withContext response.data.toResultOr { IllegalStateException() }
    }
}
