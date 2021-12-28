package com.umbatest.www

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TmdbRepository {
    suspend fun getLatestMovies(pageNum: Int) = TmdbApi.retrofitService.getLatestTvShows(pageNum)
    suspend fun getPopularMovies(pageNum: Int) = TmdbApi.retrofitService.getPopularTvShows(pageNum)
    suspend fun getUpcomingMovies(pageNum: Int) =
        TmdbApi.retrofitService.getUpcomingTvShows(pageNum)
}