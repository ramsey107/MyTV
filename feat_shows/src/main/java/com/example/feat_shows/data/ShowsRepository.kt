package com.example.feat_shows.data

import com.example.data.source.remote.api.TVService
import com.example.feat_shows.domain.model.MappedTvShow
import com.example.feat_shows.domain.model.TvShow
import com.example.feat_shows.domain.repository.IShowsRepository
import javax.inject.Inject

class ShowsRepository @Inject constructor(
    private val apiService: TVService
) : IShowsRepository {
    override suspend fun getPopularShows(language: String, page: Int): List<TvShow> {
        val mappedTvShow = MappedTvShow()
        val response = apiService.getPopularShows(language, page)
        return mappedTvShow.map(response)
    }
}