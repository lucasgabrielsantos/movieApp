package com.lucas.movies.home.data.datasource

import com.lucas.movies.home.data.api.MovieService
import com.lucas.movies.home.data.model.MovieResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class MoviesRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRemoteDataSource {
    override fun getNowPlayingMovies(page: Int): Flow<MovieResult> = flow {
        emit(movieService.getNowPlayingMovies(page))
    }.flowOn(dispatcher)
}