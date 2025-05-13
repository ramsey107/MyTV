package com.example.feat_shows.presentation.mvi

import com.example.core.mvi.MviIntent

sealed class ShowsIntent : MviIntent {
    object LoadShows : ShowsIntent()
    data class ShowSelected(val showId: Int) : ShowsIntent()
    object Retry : ShowsIntent()
} 