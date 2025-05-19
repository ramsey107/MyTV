package com.example.feat_shows.dispatcher

import com.example.core.dispatcher.IntentDispatcher
import com.example.core.handler.IntentHandler
import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState
import javax.inject.Inject

class IntentDispatcherImpl @Inject constructor(
    private val handlers: Map<Class<out UiIntent>, @JvmSuppressWildcards IntentHandler<out UiIntent>>
): IntentDispatcher {
    @Suppress("UNCHECKED_CAST")
    override suspend fun dispatch(intent: UiIntent): UiState {
        val handler = handlers[intent::class.java]
            ?: error("No handler found for ${intent::class}")
        return (handler as IntentHandler<UiIntent>).handle(intent)
    }
}