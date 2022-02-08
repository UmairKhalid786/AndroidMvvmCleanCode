package com.techlad.android_mvvm_clean_code.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by umair.khalid on 25,January,2022
 **/

class UrlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        request = request.newBuilder().url(removeLastBackslashFromLast(request)).build()

        return chain.proceed(request)
    }


    private fun removeLastBackslashFromLast(request: Request): String {
        val url = request.url.toString()
        return if (url.last() == '/') url.dropLast(1) else url
    }
}