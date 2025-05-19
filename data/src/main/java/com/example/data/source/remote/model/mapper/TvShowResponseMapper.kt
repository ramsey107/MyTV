package com.example.data.source.remote.model.mapper

import com.example.core.model.TvShow
import com.example.core.utils.Mapper
import com.example.data.source.remote.model.responsemodels.TvShowResponseDto
import javax.inject.Inject

data class PaginatedShows(
    val shows: List<TvShow>,
    val currentPage: Int,
    val totalPages: Int
)

class TvShowResponseMapper @Inject constructor(): Mapper<TvShowResponseDto, PaginatedShows> {
    override fun map(i: TvShowResponseDto): PaginatedShows {
        return PaginatedShows(
            shows = i.results.map {
                TvShow(
                    id = it.id,
                    name = it.name,
                    poster = it.poster_path ?: "",
                    language = it.original_language
                )
            },
            currentPage = i.page,
            totalPages = i.total_pages
        )
    }
}
