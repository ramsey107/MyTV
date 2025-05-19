package com.example.core.model

data class TvShowDetails(
    val poster: String,
    val name: String,
    val genres: List<String>,
    val numberOfSeasons: Int,
    val country: String,
    val popularity: Double,
    val overview: String
)
