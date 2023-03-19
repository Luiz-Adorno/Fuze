package com.example.fuze.repository

import com.example.fuze.network.model.TeamResponse


interface TeamRepository {

    suspend fun getTeam(id: Int): TeamResponse

}
