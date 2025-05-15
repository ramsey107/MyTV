package com.example.feat_shows.intent

import javax.annotation.concurrent.Immutable

@Immutable
sealed class HomeScreenIntent {
    data object FetchPopularShows : HomeScreenIntent()
    data class SelectShow(val id: Int) : HomeScreenIntent()
    data object RefreshScreen : HomeScreenIntent()
    data class BookMarkShow(val id: Int) : HomeScreenIntent()
}

