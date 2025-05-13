package com.example.feat_shows.presentation.mvi

import com.example.core.mvi.MviState
import com.example.feat_shows.domain.model.TvShow

data class ShowsState(
    val isLoading: Boolean = false,
    val shows: List<TvShow> = emptyList(),
    val error: String? = null
) : MviState 