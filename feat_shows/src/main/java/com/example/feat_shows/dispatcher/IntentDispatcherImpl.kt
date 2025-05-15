package com.example.feat_shows.dispatcher

import com.example.feat_shows.handler.IntentHandler
import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState
import javax.inject.Inject

class IntentDispatcherImpl @Inject constructor(
    private val handlers: Map<Class<out HomeScreenIntent>, @JvmSuppressWildcards IntentHandler<out HomeScreenIntent>>
): IntentDispatcher {
    @Suppress("UNCHECKED_CAST")
    override suspend fun dispatch(intent: HomeScreenIntent): UiState {
        val handler = handlers[intent::class.java]
            ?: error("No handler found for ${intent::class}")
        return (handler as IntentHandler<HomeScreenIntent>).handle(intent)
    }
}