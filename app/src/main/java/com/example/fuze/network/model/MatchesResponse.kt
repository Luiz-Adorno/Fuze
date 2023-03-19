package com.example.fuze.network.model

data class MatchesResponse(
    val begin_at: String,
    val detailed_stats: Boolean,
    val draw: Boolean,
    val id: Int,
    val league: League,
    val match_type: String,
    val games: List<Games>,
    val modified_at: String,
    val opponents: List<Opponent>,
    val original_scheduled_at: String,
    val rescheduled: Boolean,
    val scheduled_at: String,
    val serie_id: Int,
    val status: String
)