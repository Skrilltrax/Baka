package dev.skrilltrax.baka.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import dev.skrilltrax.baka.core.network.GetTrendingAnimeQuery
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class AnimeRepository @Inject constructor(private val apolloClient: ApolloClient) {

  public suspend fun getTrendingAnime(
    page: Int = 1,
    perPage: Int = 20,
    showAdult: Boolean = false
  ): Unit =
    withContext(Dispatchers.IO) {
      val response =
        apolloClient
          .query(GetTrendingAnimeQuery(page, perPage, Optional.presentIfNotNull(showAdult)))
          .execute()
      if (response.hasErrors()) {
        println(response.errors?.firstOrNull()?.message)
        return@withContext
      }

      println(response.data.toString())
    }
}
