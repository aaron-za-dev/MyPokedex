package com.aaronzadev.mypokedex

import android.app.Application
import androidx.room.Room
import com.aaronzadev.mypokedex.data.local.PokemonDB

class PokedexApp : Application() {

    lateinit var pokemonDB : PokemonDB
        private set

    override fun onCreate() {
        super.onCreate()
        pokemonDB = Room.databaseBuilder(this, PokemonDB::class.java, "pokemondb").build()
    }

}