package com.example.fuze.network.model

data class Opponent(
    val opponent: OpponentX,
    val type: String
)

data class OpponentX(
    val acronym: String,
    val id: Int,
    val image_url: String?,
    val location: String,
    val modified_at: String,
    val name: String,
    val slug: String
)