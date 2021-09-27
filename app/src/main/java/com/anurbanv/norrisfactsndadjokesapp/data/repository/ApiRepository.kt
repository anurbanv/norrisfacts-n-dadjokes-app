package com.anurbanv.norrisfactsndadjokesapp.data.repository

import com.anurbanv.norrisfactsndadjokesapp.data.network.RetrofitClient
import com.anurbanv.norrisfactsndadjokesapp.data.network.dto.DadJoke
import com.anurbanv.norrisfactsndadjokesapp.data.network.dto.NorrisFact

class ApiRepository(private val retrofitClient: RetrofitClient) {

    suspend fun getChuckNorrisFact(): NorrisFact {
        return retrofitClient.chuckNorrisFactsApi.getFact()
    }

    suspend fun getDadJoke(): DadJoke {
        return retrofitClient.dadJokesApi.getJoke()
    }
}