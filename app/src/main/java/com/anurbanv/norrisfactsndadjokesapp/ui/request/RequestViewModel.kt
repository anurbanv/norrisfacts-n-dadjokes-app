package com.anurbanv.norrisfactsndadjokesapp.ui.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anurbanv.norrisfactsndadjokesapp.App
import com.anurbanv.norrisfactsndadjokesapp.R
import com.anurbanv.norrisfactsndadjokesapp.data.network.dto.TextContentObject
import com.anurbanv.norrisfactsndadjokesapp.data.repository.ApiRepository
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext
import java.io.IOException

class RequestViewModel(
    private val apiRepository: ApiRepository, private val requestType: RequestType
) : ViewModel() {

    private val resultString = MutableLiveData<String>()
    private val errorString = MutableLiveData<String>()

    suspend fun requestApi() {
        try {
            val result: TextContentObject = if (requestType == RequestType.NORRIS_FACT) {
                apiRepository.getChuckNorrisFact()
            } else {
                apiRepository.getDadJoke()
            }
            withContext(Main) {
                resultString.value = result.content
                errorString.value = ""
            }
        } catch (e: IOException) {
            val errorMessage = App.instance.getString(
                if (requestType == RequestType.NORRIS_FACT)
                    R.string.error_norris_fact else R.string.error_dad_joke
            )
            withContext(Main) { errorString.value = errorMessage }
        }
    }

    fun getResultString(): LiveData<String> = resultString

    fun getErrorString(): LiveData<String> = errorString
}