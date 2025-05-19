package com.example.feat_shows.repository

import com.example.core.common.Errors
import com.example.core.common.Keys
import com.example.core.shared.state.UiState
import com.example.data.source.remote.api.TVService
import com.example.data.source.remote.model.mapper.TvShowDetailsResponseMapper
import com.example.data.source.remote.model.mapper.TvShowResponseMapper
import com.example.data.source.repository.IShowsRepository
import javax.inject.Inject

class ShowsRepository @Inject constructor(
    private val apiService: TVService,
) : IShowsRepository {
    override suspend fun getPopularShows(language: String, page: Int): UiState {
        val mapper = TvShowResponseMapper()
        return try {
            val response = apiService.getPopularShows(language, page, "Bearer ${Keys.apiKey}")
            val paginatedShows = mapper.map(response)
            UiState.ShowsListSuccess(
                result = paginatedShows.shows,
                currentPage = paginatedShows.currentPage,
                totalPages = paginatedShows.totalPages
            )
        } catch(e: Exception) {
            UiState.Error(Errors.Exception(e.message ?: "Unknown error"))
        }
    }
}