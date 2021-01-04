package com.aaronzadev.mypokedex.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.domain.PokemonsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PokemonsRepository) : ViewModel() {

    //TODO
    //val pokemons : Flow<List<Pokemon>> = repository.getPokemons()

    init {
        viewModelScope.launch {
            repository.checkRequireNewPage(0)
        }
    }



}