package com.lucas.movies.home.di

import com.lucas.movies.home.data.api.MovieService
import com.lucas.movies.home.data.datasource.MoviesRemoteDataSourceImpl
import com.lucas.movies.home.data.repository.GetMoviesRepositoryImpl
import com.lucas.movies.home.domain.usecase.GetMoviesUseCase
import com.lucas.movies.home.presentation.GetMoviesViewModel
import com.lucas.network.ServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MoviesHomeModules {
    private val presentationModules = module {
        viewModel {
            GetMoviesViewModel(
                getNowPlayingMoviesUseCase = GetMoviesUseCase(
                    movieRepository = GetMoviesRepositoryImpl(
                        movieDataSource = MoviesRemoteDataSourceImpl(
                            movieService = get<ServiceFactory>().create(MovieService::class.java)
                        )
                    )
                )
            )
        }
    }

    fun loadModules() {
        loadKoinModules(
            presentationModules
        )
    }
}