package com.anurbanv.norrisfactsndadjokesapp.ui.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anurbanv.norrisfactsndadjokesapp.data.repository.ApiRepository
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

class RequestViewModel(
    private val apiRepository: ApiRepository, private val requestType: RequestType
) : ViewModel() {

    private val resultString = MutableLiveData<String>()

    suspend fun requestApi() {
        val result = if (requestType == RequestType.NORRIS_FACT) {
            apiRepository.getChuckNorrisFact().content
        } else {
            apiRepository.getDadJoke().content
        }
        withContext(Main) { resultString.value = result }
    }

    fun getResultString(): LiveData<String> = resultString

    fun isResultEmpty(): Boolean {
        return resultString.value.isNullOrBlank()
    }
}