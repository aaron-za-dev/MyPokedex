package com.aaronzadev.mypokedex.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaronzadev.mypokedex.R
import com.aaronzadev.mypokedex.data.domain.Pokemon
import com.aaronzadev.mypokedex.data.domain.PokemonsRepository
import com.aaronzadev.mypokedex.data.local.LocalDataSourceImpl
import com.aaronzadev.mypokedex.data.remote.RemoteDataSourceImpl
import com.aaronzadev.mypokedex.util.app
import com.aaronzadev.mypokedex.view.adapters.PokemonAdapter
import com.aaronzadev.mypokedex.view.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val pokemons = mutableListOf<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val viewModel : MainViewModel by viewModels()
        //val pokemonsRepository = PokemonsRepository()
        viewModel = createViewModel()

        val pokemonAdapter = PokemonAdapter(pokemons)

        lifecycleScope.launch {
            viewModel.pokemons.collect {
                pokemons.addAll(it)
                pokemonAdapter.notifyDataSetChanged()
            }
        }

        val mlayoutManager = LinearLayoutManager(this)

        val recycler = findViewById<RecyclerView>(R.id.pokerecycler).apply {
            layoutManager = mlayoutManager
            setHasFixedSize(true)
            adapter = pokemonAdapter
        }


    }

    private fun createViewModel() = MainViewModel(PokemonsRepository(LocalDataSourceImpl(app.pokemonDB), RemoteDataSourceImpl()))

}