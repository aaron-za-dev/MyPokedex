package com.aaronzadev.mypokedex.data.remote

import com.squareup.moshi.Json

data class PokemonListResponse(
    @Json(name = "count") val count: Int,
    @Json(name = "next") val next: String,
    @Json(name = "previous") val previous: String,
    @Json(name = "results") val results: MutableList<Result>
)

data class Result(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)