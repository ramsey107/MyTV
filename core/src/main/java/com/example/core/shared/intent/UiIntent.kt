package com.example.core.shared.intent

sealed class UiIntent {
    data class FetchPopularShows(val page: Int = 1): UiIntent()
}