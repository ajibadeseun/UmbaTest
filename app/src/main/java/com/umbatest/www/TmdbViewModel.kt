package com.umbatest.www

import android.app.Application
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject


public class TmdbViewModel  constructor (application: Application
) : AndroidViewModel(application) {

    private var tmdbRepository: TmdbRepository
    init {
        tmdbRepository = TmdbRepository()
    }

    fun getLatestMovies(pageNum: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = tmdbRepository.getLatestMovies(pageNum)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
    fun getPopularMovies(pageNum: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = tmdbRepository.getPopularMovies(pageNum)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
    fun getUpcomingMovies(pageNum: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = tmdbRepository.getUpcomingMovies(pageNum)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}