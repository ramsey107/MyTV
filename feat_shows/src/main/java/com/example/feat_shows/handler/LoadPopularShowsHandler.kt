package com.example.feat_shows.handler

import com.example.core.common.Errors
import com.example.feat_shows.data.ShowsRepository
import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState
import javax.inject.Inject

class FetchPopularShowsHandler @Inject constructor(
    private val showsRepository: ShowsRepository
): IntentHandler<HomeScreenIntent.FetchPopularShows> {
    override suspend fun handle(intent: HomeScreenIntent.FetchPopularShows): UiState {
        return try {
            val shows = showsRepository.getPopularShows()
            UiState.Success(shows)
        }catch (e: Exception){
            UiState.Error(Errors.Unauthorized)
        }
    }
}