package com.umbatest.www

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


enum class TmdbApiStatus { LOADING, ERROR, DONE }

data class LatestMovies(
    val page: Int,
    val results: List<LatestMoviesResult>,
    @Json(name = "total_results") val totalResults: Int,
    @Json(name = "total_pages") val totalPages: Int
)

@Parcelize
data class LatestMoviesResult(
    @Json(name = "poster_path") val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "genre_ids") val genreIds: IntArray,
    val id: Int,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "original_language") val originalLanguage: String,
    val title: String,
    @Json(name = "backdrop_path") val backdropPath: String,
    val popularity: Double,
    @Json(name = "vote_count") val voteCount: Int,
    val video: Boolean,
    @Json(name = "vote_average") val voteAverage: Double,
    ): Parcelable