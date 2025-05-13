package com.example.data.source.remote.model

data class TvShowDetailsDto(
    val adult: Boolean,
    val backdrop_path: String?,
    val created_by: List<CreatorDto>,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<GenreDto>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val last_episode_to_air: EpisodeDto?,
    val name: String,
    val next_episode_to_air: EpisodeDto?,
    val networks: List<NetworkDto>,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val production_companies: List<CompanyDto>,
    val production_countries: List<CountryDto>,
    val seasons: List<SeasonDto>
)

data class CreatorDto(
    val id: Int,
    val credit_id: String,
    val name: String,
    val original_name: String,
    val gender: Int?,
    val profile_path: String?
)

data class GenreDto(
    val id: Int,
    val name: String
)

data class EpisodeDto(
    val id: Int,
    val name: String,
    val overview: String,
    val vote_average: Double,
    val vote_count: Int,
    val air_date: String,
    val episode_number: Int,
    val episode_type: String,
    val production_code: String,
    val runtime: Int?,
    val season_number: Int,
    val show_id: Int,
    val still_path: String?
)

data class NetworkDto(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
)

data class CompanyDto(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
)

data class CountryDto(
    val iso_3166_1: String,
    val name: String
)

data class SeasonDto(
    val air_date: String?,
    val episode_count: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String?,
    val season_number: Int,
    val vote_average: Double
)
