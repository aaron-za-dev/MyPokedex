package com.aaronzadev.mypokedex.data.remote

import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.domain.RemoteDataSource
import com.aaronzadev.mypokedex.util.toDomainPokemon

class RemoteDataSourceImpl() : RemoteDataSource {

    override suspend fun getPokemons(offset: Int, size: Int): List<Pokemon> =
        PokemonServiceImpl.service.getPokemonList(offset, size).results.map{ it.toDomainPokemon() }
}