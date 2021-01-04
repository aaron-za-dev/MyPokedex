package com.aaronzadev.mypokedex.data.domain

interface RemoteDataSource {
    suspend fun getPokemons(page: Int) : List<Pokemon>
}