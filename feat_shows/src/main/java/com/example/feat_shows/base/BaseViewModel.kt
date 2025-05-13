package com.example.feat_shows.base

import androidx.lifecycle.ViewModel
import com.example.feat_shows.intent.BookMarkShow
import com.example.feat_shows.intent.LoadPopularShows
import com.example.feat_shows.intent.ScreenRefreshed
import com.example.feat_shows.intent.ShowButtonClick
import com.example.feat_shows.intent.UiIntent
import com.example.feat_shows.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel(){

    private var _state = MutableStateFlow(UiState.Nothing)
    val state = _state.asStateFlow()

    abstract fun sendIntent(intent: UiIntent)

    fun handleIntent(intent: UiIntent){
        when(intent){
            is BookMarkShow -> TODO()
            LoadPopularShows -> TODO()
            ScreenRefreshed -> TODO()
            is ShowButtonClick -> TODO()
        }
    }
}