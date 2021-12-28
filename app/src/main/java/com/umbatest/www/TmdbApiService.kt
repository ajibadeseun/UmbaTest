package com.umbatest.www

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.umbatest.www.Urls.Companion.LATEST_SHOWS_PATH
import com.umbatest.www.Urls.Companion.POPULAR_SHOWS_PATH
import com.umbatest.www.Urls.Companion.UPCOMING_SHOW_PATH
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Urls.TMDB_BASE_URL)
    .build()

interface TmdbApiService {
    @GET(LATEST_SHOWS_PATH)
    suspend fun getLatestTvShows(@Query("page") pageNum: Int): LatestMovies

    @GET(POPULAR_SHOWS_PATH)
    suspend fun getPopularTvShows(@Query("page") pageNum: Int): LatestMovies

    @GET(UPCOMING_SHOW_PATH)
    suspend fun getUpcomingTvShows(@Query("page") pageNum: Int): LatestMovies
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object TmdbApi {
    val retrofitService: TmdbApiService by lazy { retrofit.create(TmdbApiService::class.java) }
}