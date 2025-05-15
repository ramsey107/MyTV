package com.example.feat_shows.dispatcher

import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState

interface IntentDispatcher {
    suspend fun dispatch(intent: HomeScreenIntent): UiState
}