package com.techlad.android_mvvm_clean_code.feature_sections.domain

import java.lang.Exception

/**
 * Created by umair.khalid on 25,January,2022
 **/

data class Resource<out T>(val status: Status, val  data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: Exception): Resource<T> {
            return Resource(Status.ERROR, null, exception.message ?: "Something went wrong")
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}