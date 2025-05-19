package com.example.data.source.remote.api

import com.example.data.source.remote.model.responsemodels.TvShowDetailsDto
import com.example.data.source.remote.model.responsemodels.TvShowResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface TVService {

    @GET("popular")
    suspend fun getPopularShows(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Header("Authorization") token: String
    ): TvShowResponseDto


    @GET("{id}")
    suspend fun getShowDetails(
        @Path("id") id: Int,
        @Query("language") language: String,
        @Header("Authorization") token: String
    ): TvShowDetailsDto

}