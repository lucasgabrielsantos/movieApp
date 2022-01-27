package com.lucas.movies.home.data.repository

import app.cash.turbine.test
import com.lucas.movies.home.data.datasource.MoviesRemoteDataSource
import com.lucas.movies.home.data.model.Movie
import com.lucas.movies.home.data.model.MovieResult
import com.lucas.movies.home.domain.model.MovieEntity
import com.lucas.movies.home.domain.repository.GetMoviesRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class MovieRepositoryImplTest {

    private val movieDataSource: MoviesRemoteDataSource = mockk()

    private val movieRepository: GetMoviesRepository = GetMoviesRepositoryImpl(
        movieDataSource
    )

    @Test
    fun `getNowPlayingMovies should return movie entity list with default posterPath`() =
        runBlocking {
            // Given
            val page = 0
            val expected = listOf(
                MovieEntity(
                    id = 123,
                    title = "Some Title",
                    posterPath = "https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                    votes = 0.0f
                )
            )
            every { movieDataSource.getNowPlayingMovies(page) } returns flowOf(
                MovieResult(
                    id = 0, totalPages = 0, results = listOf(
                        Movie(
                            id = 123, title = "Some Title", posterPath = null, votes = 0.0f
                        )
                    )
                )
            )

            // When
            val result = movieRepository.getNowPlayingMovies(page)

            // Then
            result.test {
                assertEquals(expected, expectItem())
                expectComplete()
            }
        }

    @Test
    fun `getNowPlayingMovies should return movie entity list`() = runBlocking {
        // Given
        val page = 0
        val expected = listOf(
            MovieEntity(
                id = 123,
                title = "Some Title",
                posterPath = "https://image.tmdb.org/t/p/w500/teste.png",
                votes = 0.0f
            )
        )
        every { movieDataSource.getNowPlayingMovies(page) } returns flowOf(
            MovieResult(
                id = 0, totalPages = 0, results = listOf(
                    Movie(
                        id = 123, title = "Some Title", posterPath = "/teste.png", votes = 0.0f
                    )
                )
            )
        )

        // When
        val result = movieRepository.getNowPlayingMovies(page)

        // Then
        result.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }
}