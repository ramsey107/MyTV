package com.example.feat_shows.handler

import com.example.feat_shows.intent.LoadPopularShows
import com.example.feat_shows.intent.UiIntent
import com.example.feat_shows.state.UiState

class LoadPopularShowsHandler(): IntentHandler<UiIntent> {
    override suspend fun handle(intent: UiIntent): UiState {
        when(intent){
            LoadPopularShows -> {

            }
            else -> {
                throw Exception(Error("Can't find any such intent"))
            }
        }
        return UiState.Loading
    }
}