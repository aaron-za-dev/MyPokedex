package com.aaronzadev.mypokedex.data.local

import com.aaronzadev.mypokedex.data.domain.LocalDataSource
import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.util.toDomainPokemon
import com.aaronzadev.mypokedex.util.toRoomPokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSourceImpl(db: PokemonDB) : LocalDataSource {

    private val pokemonDAO = db.pokemonDao()

    override fun getPokemons(): Flow<List<Pokemon>> {
        return pokemonDAO.getAll().map { pokemons -> pokemons.map { it.toDomainPokemon() } }
    }

    override suspend fun size(): Int {
        return pokemonDAO.pokemonsCount()
    }

    override suspend fun savePokemons(newPokemons: List<Pokemon>) {
        pokemonDAO.insertPokemons(newPokemons.map { it.toRoomPokemon() })
    }
}