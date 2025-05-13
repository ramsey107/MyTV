package com.example.feat_shows.presentation.mvi

import com.example.core.mvi.MviEffect

sealed class ShowsEffect : MviEffect {
    data class NavigateToShowDetails(val showId: Int) : ShowsEffect()
    data class ShowError(val message: String) : ShowsEffect()
} 