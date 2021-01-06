package com.aaronzadev.mypokedex.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aaronzadev.mypokedex.R
import com.aaronzadev.mypokedex.data.domain.Pokemon

class PokemonAdapter(private val pokemons : MutableList<Pokemon>) : RecyclerView.Adapter<PokemonHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent,false)
        return PokemonHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.txtPokemon.text = pokemons[position].name
        holder.imgPokemon.setImageResource(R.drawable.pokeball)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

}

class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val txtPokemon = itemView.findViewById<TextView>(R.id.tv_pokemon_name)
    val imgPokemon = itemView.findViewById<ImageView>(R.id.im_pokemon)

}