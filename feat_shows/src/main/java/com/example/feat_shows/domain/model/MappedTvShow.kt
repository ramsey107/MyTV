package com.example.feat_shows.domain.model

import com.example.core.utils.Mapper
import com.example.data.source.remote.model.TvShowResponseDto

class MappedTvShow: Mapper<TvShowResponseDto, List<TvShow>> {
    override fun map(i: TvShowResponseDto): List<TvShow> {
        return i.results.map {
            TvShow(
                id = it.id,
                name = it.name,
                poster = it.poster_path ?: "",
                language = it.original_language
            )
        }
    }
}
