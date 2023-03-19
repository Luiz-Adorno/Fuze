package com.example.fuze.network.api

import com.example.fuze.network.model.TeamResponse
import com.example.fuze.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TeamApi {

    @Headers("authorization: $API_KEY")
    @GET("teams/{id}")
    suspend fun getMatches(
        @Path("id") id: Int
    ): TeamResponse
}