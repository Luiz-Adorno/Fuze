package com.example.fuze.repository

import com.example.fuze.network.api.TeamApi
import com.example.fuze.network.model.TeamResponse

class TeamRepositoryImpl (
    private val teamApi: TeamApi
): TeamRepository {
    override suspend fun getTeam(id: Int): TeamResponse {
        return teamApi.getMatches(id)
    }

}