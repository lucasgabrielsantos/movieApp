package com.lucas.movies.home.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal data class MovieResult(
    @SerializedName("page") val id: Long,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<Movie>
) : Serializable

internal data class Movie(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val posterPath: String? = "",
    @SerializedName("vote_average") val votes: Float
) : Serializable