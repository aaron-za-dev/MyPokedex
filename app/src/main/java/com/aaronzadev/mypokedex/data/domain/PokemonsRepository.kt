package com.aaronzadev.mypokedex.data.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withTimeout


class PokemonsRepository(private val localDataSource: LocalDataSource,
                         private val remoteDataSource: RemoteDataSource) {

    //private val DEFAULTOFFSET = 0 //pageNumber
    private val DEFAULTLIMIT = 20 //pageSize or items per page

    fun getPokemons(): Flow<List<Pokemon>> = localDataSource.getPokemons()

    suspend fun checkRequireNewPage(lastVisiblePokemon: Int) {
        val size = localDataSource.size()
        if (lastVisiblePokemon >= size - DEFAULTLIMIT) {
            val page = size / DEFAULTLIMIT //+ 1
            val newPokemons = withTimeout(5_000) {
                remoteDataSource.getPokemons(page, DEFAULTLIMIT)
            }
            localDataSource.savePokemons(newPokemons)
        }
    }

}