package com.example.feat_shows.presentation.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.core.mvi.MviViewModel
import com.example.data.source.remote.api.TVService
import com.example.feat_shows.presentation.mvi.ShowsEffect
import com.example.feat_shows.presentation.mvi.ShowsIntent
import com.example.feat_shows.presentation.mvi.ShowsState
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowsViewModel @Inject constructor(
    private val tvService: TVService
) : MviViewModel<ShowsIntent, ShowsState, ShowsEffect>() {

    override fun createInitialState(): ShowsState = ShowsState()

    override fun handleIntent(intent: ShowsIntent) {
        when (intent) {
            is ShowsIntent.LoadShows -> loadShows()
            is ShowsIntent.ShowSelected -> handleShowSelected(intent.showId)
            is ShowsIntent.Retry -> loadShows()
        }
    }

    private fun loadShows() {
        viewModelScope.launch {
            setState { copy(isLoading = true, error = null) }
            try {
                val response = tvService.getPopularShows("en-US")
//                setState { copy(isLoading = false, shows = response.results) }
            } catch (e: Exception) {
                setState { copy(isLoading = false, error = e.message) }
                setEffect { ShowsEffect.ShowError(e.message ?: "Unknown error occurred") }
            }
        }
    }

    private fun handleShowSelected(showId: Int) {
        setEffect { ShowsEffect.NavigateToShowDetails(showId) }
    }
}