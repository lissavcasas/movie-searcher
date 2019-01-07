package com.activityexample.activitycycle.repository.remove.api

import com.activityexample.activitycycle.BuildConfig
import com.activityexample.activitycycle.ui.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDbApi {
    @GET(BuildConfig.URL_SEARCH_MOVIE)
    fun movieList(
            @Query("api_key") api_key: String,
            @Query("query") query: String
    ): Call<Movie>
}