package com.techlad.android_mvvm_clean_code.utils

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import java.lang.Exception
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


/**
 * Created by umair.khalid on 25,January,2022
 **/


fun <T, A> performGetOperation(
    databaseQuery: () -> Flow<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit,
) = flow {

    emit(Resource.loading(null))
    val source = databaseQuery.invoke().map { Resource.success(it) }
    emitAll(source)


    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Resource.Status.SUCCESS) {
        responseStatus.data?.let { saveCallResult(it) }
    } else if (responseStatus.status == Resource.Status.ERROR) {
        emit(Resource.error(Exception(responseStatus.message)))
        emitAll(source)
    }
}.flowOn(Dispatchers.IO)

fun <T> performGetOperation(
    databaseQuery: () -> Flow<T>,
) = flow {
    emit(Resource.loading())
    val source = databaseQuery.invoke().map { Resource.success(it) }
    emitAll(source)
}.flowOn(Dispatchers.IO)