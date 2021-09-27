package com.anurbanv.norrisfactsndadjokesapp.ui.request

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anurbanv.norrisfactsndadjokesapp.App

class RequestViewModelFactory(private val requestType: RequestType) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RequestViewModel::class.java)) {
            val apiRepository = App.instance.apiRepository
            @Suppress("UNCHECKED_CAST")
            return RequestViewModel(apiRepository, requestType) as T
        }
        throw IllegalAccessException("Unable to construct ViewModel")
    }
}