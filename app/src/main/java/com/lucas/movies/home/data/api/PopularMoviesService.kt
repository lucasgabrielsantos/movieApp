package com.lucas.movies.home.data.api

import com.lucas.movies.home.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int,
    ): MovieResult
}