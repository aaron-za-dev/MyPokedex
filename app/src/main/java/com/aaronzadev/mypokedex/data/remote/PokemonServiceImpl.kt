package com.aaronzadev.mypokedex.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PokemonServiceImpl {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    val service : PokemonService =
        Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().run {
                 create(PokemonService::class.java)
                }

}