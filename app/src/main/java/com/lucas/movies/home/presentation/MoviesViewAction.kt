package com.lucas.movies.home.presentation

internal sealed class MoviesViewAction {
    object ShowLoading : MoviesViewAction()
    object HideLoading : MoviesViewAction()
    object Default : MoviesViewAction()
}