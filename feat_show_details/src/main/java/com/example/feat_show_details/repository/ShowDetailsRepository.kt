package com.example.feat_show_details.repository

import com.example.core.common.Errors
import com.example.core.common.Keys
import com.example.core.shared.state.UiState
import com.example.data.source.remote.api.TVService
import com.example.data.source.remote.model.mapper.TvShowDetailsResponseMapper
import com.example.data.source.remote.model.mapper.TvShowResponseMapper
import com.example.data.source.repository.IShowsDetailsRepository
import com.example.data.source.repository.IShowsRepository

class ShowDetailsRepository(
    private val apiService: TVService,
) : IShowsDetailsRepository {
    override suspend fun getShowDetails(id: Int, language: String): UiState {
        val mapper = TvShowDetailsResponseMapper()
        return try {
            val response = apiService.getShowDetails(id, language, "Bearer ${Keys.apiKey}")
            UiState.ShowSuccess(mapper.map(response))
        } catch(e: Exception) {
            UiState.Error(Errors.Exception(e.message ?: "Unknown error"))
        }
    }
}