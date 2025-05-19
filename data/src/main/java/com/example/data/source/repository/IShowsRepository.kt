package com.example.data.source.repository

import com.example.core.shared.state.UiState

interface IShowsRepository {
    suspend fun getPopularShows(language: String = "en-US", page: Int): UiState
}