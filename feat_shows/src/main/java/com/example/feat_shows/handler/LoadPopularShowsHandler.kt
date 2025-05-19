package com.example.feat_shows.handler

import com.example.core.handler.IntentHandler
import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState
import com.example.feat_shows.di.Language
import com.example.feat_shows.repository.ShowsRepository
import javax.inject.Inject

class FetchPopularShowsHandler @Inject constructor(
    private val showsRepository: ShowsRepository,
    @Language private val language: String
) : IntentHandler<UiIntent.FetchPopularShows> {
    override suspend fun handle(intent: UiIntent.FetchPopularShows): UiState {
        return showsRepository.getPopularShows(language, intent.page)
    }
}