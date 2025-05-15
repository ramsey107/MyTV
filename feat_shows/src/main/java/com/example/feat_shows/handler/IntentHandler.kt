package com.example.feat_shows.handler

import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState

interface IntentHandler<I: HomeScreenIntent> {
    suspend fun handle(intent: I): UiState
}