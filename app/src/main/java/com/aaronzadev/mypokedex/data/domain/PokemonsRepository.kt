package com.aaronzadev.mypokedex.data.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withTimeout


class PokemonsRepository(private val localDataSource: LocalDataSource,
                         private val remoteDataSource: RemoteDataSource) {

    private val LIMIT = 20
    private val OFFSET = 10

    suspend fun getPokemons(): Flow<List<Pokemon>> = localDataSource.getPokemons()

    suspend fun checkRequireNewPage(lastVisible: Int) {
        val size = localDataSource.size()
        if (lastVisible >= size - OFFSET) {
            val page = size / LIMIT + 1
            val newPokemons = withTimeout(5_000) { remoteDataSource.getPokemons(page) }
            localDataSource.saveMovies(newPokemons)
        }
    }

}