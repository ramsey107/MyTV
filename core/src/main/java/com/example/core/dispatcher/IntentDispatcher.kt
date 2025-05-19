package com.example.core.dispatcher

import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState

interface IntentDispatcher {
    suspend fun dispatch(intent: UiIntent): UiState
}