package com.anurbanv.norrisfactsndadjokesapp

import android.app.Application
import com.anurbanv.norrisfactsndadjokesapp.data.network.RetrofitClient
import com.anurbanv.norrisfactsndadjokesapp.data.repository.ApiRepository

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    // todo implement DI (this is temporary instances container)
    lateinit var retrofitClient: RetrofitClient
    lateinit var apiRepository: ApiRepository

    override fun onCreate() {
        super.onCreate()
        instance = this

        retrofitClient = RetrofitClient()
        apiRepository = ApiRepository(retrofitClient)
    }
}