package com.lucas.movies.home.presentation

import androidx.lifecycle.ViewModel
import com.lucas.movies.home.domain.model.MovieEntity
import com.lucas.movies.home.domain.usecase.GetMoviesUseCase

private const val FIRST_PAGE_INDEX = 1

internal class GetMoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val originalMovieListView = mutableListOf<MoviesView>()

//    var moviesState = mutableStateOf(MoviesViewState())
//        private set
//
//    var moviesAction = mutableStateOf<MoviesViewAction>(MoviesViewAction.Default)
//        private set

    init {
        getNowPlayingMovies()
    }

    fun getNowPlayingMovies() {
//        viewModelScope.launch {
//            getNowPlayingMoviesUseCase(FIRST_PAGE_INDEX)
//               .onStart {}
//                .catch { }
//                .onCompletion {  }
//                .collect { moviesEntity ->
//                    val moviesView = mapMovieEntityToView(moviesEntity)
//                    updateControlMovieListView(moviesView)
//                    updateMovieListState(moviesView)
//                }
//        }
    }

    fun search(movieName: String) {
        val findMovies: List<MoviesView> = originalMovieListView.filter {
            it.title.contains(movieName, ignoreCase = true)
        }
        updateMovieListState(
            if (movieName.isEmpty() && findMovies.isEmpty()) originalMovieListView
            else findMovies
        )
    }

    private fun updateMovieListState(moviesView: List<MoviesView>) {
        // moviesState.value = moviesState.value.copy(movieList = moviesView)
    }

    private fun mapMovieEntityToView(moviesEntity: List<MovieEntity>): List<MoviesView> {
        val moviesView = moviesEntity.map {
            MoviesView(
                id = it.id,
                title = it.title,
                posterPath = it.posterPath,
                votes = it.votes.toString()
            )
        }
        return moviesView
    }

    private fun updateControlMovieListView(moviesView: List<MoviesView>) {
        originalMovieListView.clear()
        originalMovieListView.addAll(moviesView)
    }
}