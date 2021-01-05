package com.aaronzadev.mypokedex.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaronzadev.mypokedex.PokedexApp
import com.aaronzadev.mypokedex.R
import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.domain.PokemonsRepository
import com.aaronzadev.mypokedex.view.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val viewModel : MainViewModel by viewModels()
        //val pokemonsRepository = PokemonsRepository()
        //viewModel = ViewModelProvider(this)

        lifecycleScope.launch {
            viewModel.pokemons.collect { pokemons ->
                for (currentPokemon : Pokemon in pokemons){
                    Log.d("POKE", currentPokemon.name)
                }
            }
        }

        var mlayoutManager = LinearLayoutManager(this)
        val recycler = findViewById<RecyclerView>(R.id.pokerecycler).apply {
            layoutManager = mlayoutManager
            setHasFixedSize(true)

        }


    }

}