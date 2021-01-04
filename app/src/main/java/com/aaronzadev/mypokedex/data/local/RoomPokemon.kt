package com.aaronzadev.mypokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomPokemon(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
)
