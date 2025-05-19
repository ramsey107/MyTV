package com.example.data.source.repository

import com.example.core.shared.state.UiState

interface IShowsDetailsRepository {
    suspend fun getShowDetails(id: Int, language: String = "en-US"): UiState
}