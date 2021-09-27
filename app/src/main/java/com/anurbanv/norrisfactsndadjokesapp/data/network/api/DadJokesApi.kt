package com.anurbanv.norrisfactsndadjokesapp.data.network.api

import com.anurbanv.norrisfactsndadjokesapp.data.network.dto.DadJoke
import retrofit2.http.GET
import retrofit2.http.Headers

//https://icanhazdadjoke.com

interface DadJokesApi {

    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getJoke(): DadJoke
}