package com.aaronzadev.mypokedex.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    //offset = pagenumber or position in pagination api default = 0
    //limit = pagesize or number of items per page default = 20

    @GET(value = "pokemon?")
    //@GET(value = "pokemon?offset=0&limit=20")
    suspend fun getPokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20
    ): PokemonListResponse

}