package com.anurbanv.norrisfactsndadjokesapp.data.network

import com.anurbanv.norrisfactsndadjokesapp.data.network.Constants.DAD_JOKE_API_BASE_URL
import com.anurbanv.norrisfactsndadjokesapp.data.network.Constants.NORRIS_API_BASE_URL
import com.anurbanv.norrisfactsndadjokesapp.data.network.Constants.USER_AGENT
import com.anurbanv.norrisfactsndadjokesapp.data.network.api.ChuckNorrisFactsApi
import com.anurbanv.norrisfactsndadjokesapp.data.network.api.DadJokesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val norrisRetrofitClient by lazy {
        createRetrofitClient(NORRIS_API_BASE_URL)
    }

    private val dadJokesRetrofitClient by lazy {
        createRetrofitClient(DAD_JOKE_API_BASE_URL)
    }

    private val okHttClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(UserAgentInterceptor(USER_AGENT))
            .build()
    }

    private fun createRetrofitClient(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val chuckNorrisFactsApi: ChuckNorrisFactsApi by lazy {
        norrisRetrofitClient.create(ChuckNorrisFactsApi::class.java)
    }

    val dadJokesApi: DadJokesApi by lazy {
        dadJokesRetrofitClient.create(DadJokesApi::class.java)
    }
}