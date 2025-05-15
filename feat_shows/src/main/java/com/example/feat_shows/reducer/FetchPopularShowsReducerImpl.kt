package com.example.feat_shows.reducer

import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState

class FetchPopularShowsReducerImpl(

): IntentReducer<HomeScreenIntent.FetchPopularShows,UiState> {
    override fun reduce(intent: HomeScreenIntent.FetchPopularShows, state: UiState) {
        when(state){
            is UiState.Error -> TODO()
            UiState.Loading -> TODO()
            UiState.Nothing -> TODO()
            is UiState.Success -> TODO()
        }
    }
}