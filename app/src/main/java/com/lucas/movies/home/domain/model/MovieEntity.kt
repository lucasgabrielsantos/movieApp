package com.lucas.movies.home.domain.model

internal data class MovieEntity(
    val id: Long,
    val title: String,
    val posterPath: String,
    val votes: Float
)