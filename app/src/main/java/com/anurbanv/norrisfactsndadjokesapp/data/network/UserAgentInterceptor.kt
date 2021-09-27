package com.anurbanv.norrisfactsndadjokesapp.data.network

import okhttp3.Interceptor
import okhttp3.Response

class UserAgentInterceptor(private val userAgent: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        request.newBuilder()
            .header("User-Agent", userAgent)
            .build()
        return chain.proceed(request)
    }
}