package com.anurbanv.norrisfactsndadjokesapp.ui.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RequestViewModel(private val requestType: RequestType) : ViewModel() {

    private val resultString = MutableLiveData<String>()

    suspend fun requestApi() {
        val result = "temp result $requestType"
        delay(1000)
        withContext(Main) { resultString.value = result }
    }

    fun getResultString(): LiveData<String> = resultString
}