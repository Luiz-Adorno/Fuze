package com.example.fuze.network.model

import com.google.gson.annotations.SerializedName

data class Players(
    val image_url: String?,
    val first_name: String,
    @SerializedName("name")
    val nickName: String,
    val last_name: String
)