package dev.skrilltrax.baka.data.model.media

import dev.skrilltrax.baka.data.model.CoverImage
import dev.skrilltrax.baka.data.model.common.FuzzyDate

public data class Media(
  val id: Int,
  val title: MediaTitle,
  val coverImage: CoverImage,
  val startDate: FuzzyDate,
  val endDate: FuzzyDate,
  val bannerImage: String,
  val season: String,
  val seasonYear: Int,
  val description: String,
  val type: MediaType,
  val format: MediaFormat,
  val status: MediaStatus,
  val episodes: Int,
  val duration: Int,
  val chapters: Int,
  val volumes: Int,
  val genres: List<String>,
  val isAdult: Boolean,
  val averageScope: Int,
  val popularity: Int,
)
