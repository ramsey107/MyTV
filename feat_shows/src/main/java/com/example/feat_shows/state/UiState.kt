package com.example.feat_shows.state

import com.example.core.common.Errors
import com.example.data.source.remote.model.feat.list.TvShow

sealed class UiState {
    data object Loading : UiState()
    data class Success(val shows: List<TvShow>) : UiState()
    data class Error(val error: Errors) : UiState()
    data object Nothing : UiState()
}

