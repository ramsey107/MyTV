package com.example.core.shared.state

import com.example.core.common.Errors
import com.example.core.model.TvShow
import com.example.core.model.TvShowDetails

sealed class UiState {
    data object Loading : UiState()
    data class ShowsListSuccess(
        val result: List<TvShow>,
        val currentPage: Int,
        val totalPages: Int
    ) : UiState()
    data class ShowSuccess(val result: TvShowDetails) : UiState()
    data class Error(val error: Errors) : UiState()
    data object Empty : UiState()
}
