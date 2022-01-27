package com.lucas.movies.home.domain.repository

import com.lucas.movies.home.domain.model.MovieEntity
import kotlinx.coroutines.flow.Flow

internal interface GetMoviesRepository {
    fun getNowPlayingMovies(page: Int): Flow<List<MovieEntity>>
}