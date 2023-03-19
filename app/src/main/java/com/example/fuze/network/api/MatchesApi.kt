package com.example.fuze.network.api

import com.example.fuze.network.model.MatchesResponse
import com.example.fuze.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MatchesApi {

    @Headers("authorization: $API_KEY")
    @GET("matches")
    suspend fun getMatches(
        @Query("page") page : Int,
        @Query("per_page") perPage : Int
    ): List<MatchesResponse>
}