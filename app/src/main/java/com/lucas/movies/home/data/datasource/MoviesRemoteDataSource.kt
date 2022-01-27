package com.lucas.movies.home.data.datasource

import com.lucas.movies.home.data.model.MovieResult
import kotlinx.coroutines.flow.Flow

internal interface MoviesRemoteDataSource {
    fun getNowPlayingMovies(page: Int): Flow<MovieResult>
}