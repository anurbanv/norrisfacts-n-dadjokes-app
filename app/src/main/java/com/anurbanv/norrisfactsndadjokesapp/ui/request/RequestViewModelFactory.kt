package com.anurbanv.norrisfactsndadjokesapp.ui.request

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RequestViewModelFactory(private val requestType: RequestType) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RequestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RequestViewModel(requestType) as T
        }
        throw IllegalAccessException("Unable to construct ViewModel")
    }
}