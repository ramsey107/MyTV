package com.example.data.source.remote.api

import com.example.data.source.remote.model.TvShowDetailsDto
import com.example.data.source.remote.model.TvShowResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVService {

    @GET("/popular")
    suspend fun getPopularShows(
        @Query("language") language: String,
        @Query("page") page: Int = 1,
    ): TvShowResponseDto


    @GET("/{id}")
    suspend fun getShowDetails(
        @Path("id") id: Int
    ): TvShowDetailsDto

}