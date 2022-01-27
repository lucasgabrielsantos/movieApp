package com.lucas.movies.home.presentation

internal data class MoviesViewState(
    val movieList: List<MoviesView> = emptyList()
)

internal data class MoviesView(
    val id: Long,
    val title: String,
    val posterPath: String,
    val votes: String
)