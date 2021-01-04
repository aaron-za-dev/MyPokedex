package com.aaronzadev.mypokedex

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aaronzadev.mypokedex.data.local.PokemonDB

class PokedexApp : Application() {

    lateinit var pokemonDatabase : PokemonDB
        private set

    override fun onCreate() {
        super.onCreate()
        pokemonDatabase = Room.databaseBuilder(this, PokemonDB::class.java, "pokemondb").build()
    }

}