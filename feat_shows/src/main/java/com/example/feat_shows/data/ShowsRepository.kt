package com.example.feat_shows.data

import com.example.core.secrets.Keys
import com.example.data.source.remote.api.TVService
import com.example.data.source.remote.model.feat.list.TvShow
import com.example.data.source.remote.model.feat.list.TvShowResponseMapper
import com.example.feat_shows.domain.repository.IShowsRepository
import javax.inject.Inject

class ShowsRepository @Inject constructor(
    private val apiService: TVService,
) : IShowsRepository {
    override suspend fun getPopularShows(language: String, page: Int): List<TvShow> {
        val mapper = TvShowResponseMapper()
        val response = apiService.getPopularShows(language, page, "Bearer ${Keys.apiKey}")
        return mapper.map(response)
    }
}