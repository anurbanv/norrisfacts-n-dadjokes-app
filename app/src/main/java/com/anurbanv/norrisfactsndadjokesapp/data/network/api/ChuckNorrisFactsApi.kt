package com.anurbanv.norrisfactsndadjokesapp.data.network.api

import com.anurbanv.norrisfactsndadjokesapp.data.network.dto.NorrisFact
import retrofit2.http.GET

//https://api.chucknorris.io

interface ChuckNorrisFactsApi {

    @GET("jokes/random")
    suspend fun getFact(): NorrisFact
}