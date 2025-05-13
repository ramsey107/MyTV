package com.example.feat_shows.state

import com.example.core.common.Errors

sealed class UiState {
    data object Loading : UiState()
    data class Success<T>(val t: T) : UiState()
    data class Error(val error: Errors) : UiState()
    data object Nothing : UiState()
}

