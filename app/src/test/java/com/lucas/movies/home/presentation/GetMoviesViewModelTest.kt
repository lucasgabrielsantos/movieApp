//package com.lucas.movie.home.presentation
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.lucas.movie.home.domain.model.MovieEntity
//import com.lucas.movie.home.domain.usecase.GetMoviesUseCase
//import io.mockk.every
//import io.mockk.mockk
//import junit.framework.Assert.assertEquals
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.runBlocking
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import kotlin.time.ExperimentalTime
//
//@ExperimentalCoroutinesApi
//@ExperimentalTime
//internal class GetMoviesViewModelTest {
//
//    @get:Rule
//    val instantTestExecutorRule = InstantTaskExecutorRule()
//
//    private val testCoroutineDispatcher = TestCoroutineDispatcher()
//    private val getNowPlayingMoviesUseCase: GetMoviesUseCase = mockk()
//    private lateinit var moviesViewModel: GetMoviesViewModel
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testCoroutineDispatcher)
//    }
//
//    @Test
//    fun `init should update state with movie list`() = runBlocking {
//        // Given
//        val page = 1
//        val expected = MoviesViewState(
//            listOf(
//                MoviesView(
//                    id = 123,
//                    title = "Some Title",
//                    posterPath = "https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
//                    votes = "6.9"
//                )
//            )
//        )
//        every { getNowPlayingMoviesUseCase.invoke(page) } returns flowOf(
//            listOf(
//                MovieEntity(
//                    id = 123,
//                    title = "Some Title",
//                    posterPath = "https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
//                    votes = 6.9f
//                )
//            )
//        )
//
//        // When
//        createViewModel()
//
//        // Then
//        assertEquals(expected, moviesViewModel.moviesState.value)
//    }
//
//    private fun createViewModel() {
//        moviesViewModel = GetMoviesViewModel(
//            getNowPlayingMoviesUseCase
//        )
//    }
//
//    @After
//    fun after() {
//        Dispatchers.resetMain()
//        testCoroutineDispatcher.cleanupTestCoroutines()
//    }
//
//}