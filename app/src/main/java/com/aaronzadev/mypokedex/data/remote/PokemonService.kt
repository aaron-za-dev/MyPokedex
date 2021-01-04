package com.aaronzadev.mypokedex.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET(value = "pokemon?")
    //@GET(value = "pokemon?offset=0&limit=20")
    suspend fun getPokemonList(@Query("offset") offset : String,
                               @Query("limit") limit : String) : PokemonListResponse

}