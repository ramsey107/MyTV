package com.example.feat_shows.intent

sealed interface UiIntent

data object LoadPopularShows : UiIntent
data class ShowButtonClick(val id: Int) : UiIntent
data object ScreenRefreshed : UiIntent
data class BookMarkShow(val id: Int) : UiIntent

