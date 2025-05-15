package com.example.feat_shows.reducer

import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState

interface IntentReducer<I: HomeScreenIntent, S: UiState> {
    fun reduce(intent: I, state: S)
}