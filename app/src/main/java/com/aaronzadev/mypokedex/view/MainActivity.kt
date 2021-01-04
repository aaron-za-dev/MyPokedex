package com.aaronzadev.mypokedex.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaronzadev.mypokedex.PokedexApp
import com.aaronzadev.mypokedex.R
import com.aaronzadev.mypokedex.view.viewmodel.MainViewModel
import kotlinx.coroutines.flow.flowOn

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MainViewModel by viewModels()

        var mlayoutManager = LinearLayoutManager(this)
        val recycler = findViewById<RecyclerView>(R.id.pokerecycler).apply {
            layoutManager = mlayoutManager
            setHasFixedSize(true)

        }


    }

}