package com.aaronzadev.mypokedex.util

import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.remote.Result

fun Result.toDomainPokemon(): Pokemon =
        Pokemon(
            0,
            name,
            url
        )