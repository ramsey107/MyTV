package com.example.core.handler

import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState

interface IntentHandler<I: UiIntent> {
    suspend fun handle(intent: I): UiState
}