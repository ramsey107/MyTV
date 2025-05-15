package com.example.feat_shows.domain.repository

import com.example.data.source.remote.model.feat.list.TvShow

interface IShowsRepository {
    suspend fun getPopularShows(language: String = "en-US", page: Int = 1): List<TvShow>
}