package com.lucas.movies.home.domain.usecase

import com.lucas.movies.home.domain.model.MovieEntity
import com.lucas.movies.home.domain.repository.GetMoviesRepository
import kotlinx.coroutines.flow.Flow


internal class GetMoviesUseCase(
    private val movieRepository: GetMoviesRepository
) {
    operator fun invoke(page: Int): Flow<List<MovieEntity>> {
        return movieRepository.getNowPlayingMovies(page)
    }
}

