package com.lucas.movies.home.data.repository

import com.lucas.movies.home.data.datasource.MoviesRemoteDataSource
import com.lucas.movies.home.data.model.MovieResult
import com.lucas.movies.home.domain.repository.GetMoviesRepository
import com.lucas.movies.home.domain.model.MovieEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class GetMoviesRepositoryImpl(
    private val movieDataSource: MoviesRemoteDataSource

) : GetMoviesRepository {
    override fun getNowPlayingMovies(page: Int): Flow<List<MovieEntity>> {
        return movieDataSource.getNowPlayingMovies(page).parseToEntity()
    }


    private fun Flow<MovieResult>.parseToEntity(): Flow<List<MovieEntity>> {
        return map { result ->
            result.results.map { movie ->
                MovieEntity(
                    id = movie.id,
                    title = movie.title,
                    posterPath = movie.posterPath.convertToImageUrl(),
                    votes = movie.votes
                )
            }
        }
    }

    private fun String?.convertToImageUrl(): String {
        val baseImageUrl = "https://image.tmdb.org/t/p/w500"

        return if (isNullOrEmpty()) {
            "$baseImageUrl/wwemzKWzjKYJFfCeiB57q3r4Bcm.png"
        } else {
            "$baseImageUrl$this"
        }
    }

}