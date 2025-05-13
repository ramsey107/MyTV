package com.example.feat_shows.handler

import com.example.feat_shows.intent.UiIntent
import com.example.feat_shows.state.UiState

interface IntentHandler<I: UiIntent> {
    suspend fun handle(intent: I): UiState
}