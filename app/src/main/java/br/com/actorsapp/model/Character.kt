package br.com.actorsapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(

    @Json(name="actor")
    val actor_name: String,

    @Json(name = "image")
    val image: String
)
