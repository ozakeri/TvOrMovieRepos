package com.example.tvormoive.network

import com.example.tvormoive.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{movieOrTV}/popular")
    suspend fun getPopular(
        @Path("movieOrTV") movieOrTV: String,
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ): Response


    @GET("{movieOrTv}/top_rated")
    suspend fun getTopRated(
        @Path("movieOrTv") movieOrTv: String,
        @Query("api_key") api_key: String,
        @Query("page") page: String
    ): Response

    @GET("trending/{movieOrTV}/week")
    suspend fun getTrendingShows(
        @Path("movieOrTV") movieOrTV: String,
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Response

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Response

    @GET("tv/airing_today")
    suspend fun getAiringTodayTV(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Response

    @GET("{movieOrTV}/{show_id}/recommendations")
    suspend fun getRecommendedShows(
        @Path("movieOrTV") movieOrTV: String,
        @Path("show_id") showId: Int,
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Response

    @GET("search/multi")
    suspend fun searchForShows(
        @Query("api_key") api_key: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ): Response

}