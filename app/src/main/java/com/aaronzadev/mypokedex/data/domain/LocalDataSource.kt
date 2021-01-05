package com.aaronzadev.mypokedex.data.domain

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getPokemons(): Flow<List<Pokemon>>

    suspend fun size(): Int

    suspend fun saveMovies(newMovies: List<Pokemon>)

}