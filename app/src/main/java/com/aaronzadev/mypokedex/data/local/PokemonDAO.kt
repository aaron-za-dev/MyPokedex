package com.aaronzadev.mypokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM RoomPokemon")
    fun getAll(): Flow<List<RoomPokemon>>

    @Query("SELECT COUNT(id) FROM RoomPokemon")
    suspend fun pokemonsCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemons(pokemons: List<RoomPokemon>)

}