package com.example.data.source.remote.model.responsemodels

data class TvShowResponseDto(
    val page: Int,
    val results: List<TvShowDto>,
    val total_pages: Int,
    val total_results: Int
)

