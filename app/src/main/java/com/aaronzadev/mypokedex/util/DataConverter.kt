package com.aaronzadev.mypokedex.util

import android.content.Context
import com.aaronzadev.mypokedex.PokedexApp
import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.local.RoomPokemon
import com.aaronzadev.mypokedex.data.remote.Result

fun Result.toDomainPokemon(): Pokemon = Pokemon(0, name, url)

fun RoomPokemon.toDomainPokemon(): Pokemon = Pokemon(id, name, url)

fun Pokemon.toRoomPokemon(): RoomPokemon = RoomPokemon(id, name, url)

val Context.app: PokedexApp
    get() = applicationContext as PokedexApp
