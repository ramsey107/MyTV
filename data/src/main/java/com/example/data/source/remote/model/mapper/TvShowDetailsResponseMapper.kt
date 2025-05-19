package com.example.data.source.remote.model.mapper

import com.example.core.model.TvShowDetails
import com.example.core.utils.Mapper
import com.example.data.source.remote.model.responsemodels.TvShowDetailsDto
import javax.inject.Inject

class TvShowDetailsResponseMapper @Inject constructor(): Mapper<TvShowDetailsDto,TvShowDetails> {
    override fun map(i: TvShowDetailsDto): TvShowDetails {
        return TvShowDetails(
            poster = i.poster_path ?: "",
            name = i.name,
            genres = i.genres.map { it.name },
            numberOfSeasons = i.number_of_seasons,
            country = i.origin_country.firstOrNull() ?: "",
            popularity = i.popularity,
            overview = i.overview
        )
    }
}