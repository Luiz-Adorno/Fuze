package com.example.fuze.network.model

data class TeamResponse(
    val acronym: Any,
    val id: Int,
    val image_url: String,
    val location: String,
    val modified_at: String,
    val name: String,
    val players: List<Any>,
    val slug: String
)