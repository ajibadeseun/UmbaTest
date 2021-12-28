package com.umbatest.www

class Urls {
    companion object{
        val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
        const val TMDB_ACCESS_TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZThhNjkxMWE3ZjhlN2MwNGIzOTk0MGNiMGE3MzE0MyIsInN1YiI6IjVjNTE2MzczOTI1MTQxNTFhOTVjNTQzYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QVnn2OGgDN2ICSGvUeVjLZfRD6DlG_uOdq5BeSVFPj0"
        const val API_KEY = "3e8a6911a7f8e7c04b39940cb0a73143"
        const val POPULAR_SHOWS_PATH = "movie/popular?api_key=${API_KEY}&language=en-US"
        const val LATEST_SHOWS_PATH = "movie/top_rated?api_key=${API_KEY}&language=en-US"
        const val UPCOMING_SHOW_PATH = "movie/upcoming?api_key=${API_KEY}&language=en-US"
    }
}