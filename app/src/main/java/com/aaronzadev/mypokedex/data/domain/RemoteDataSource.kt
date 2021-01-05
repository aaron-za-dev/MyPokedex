package com.aaronzadev.mypokedex.data.domain

//offset = pagenumber or position in pagination api
//limit = pagesize or number of items per page

interface RemoteDataSource {
    suspend fun getPokemons(offset:  Int, limit: Int) : List<Pokemon>
}