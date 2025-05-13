package com.example.feat_shows.domain.repository

import com.example.feat_shows.domain.model.TvShow

interface IShowsRepository {
    suspend fun getPopularShows(language: String = "en-US", page: Int = 0): List<TvShow>
}