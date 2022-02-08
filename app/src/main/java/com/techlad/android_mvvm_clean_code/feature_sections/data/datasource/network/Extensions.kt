package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.model.base.BaseResponse
import com.techlad.android_mvvm_clean_code.feature_sections.domain.dto.BaseDto
import retrofit2.Response

internal fun Response<*>.getException(): Exception {
    return Exception(
        message()
    )
}

fun <DomainModel, Dto : BaseDto<DomainModel>> Response<BaseResponse<Dto>>.extractResult(): Resource<DomainModel> {
    val successfulResponse = body()?.data?.toDomainModel()

    if (isSuccessful && successfulResponse != null) {
        return Resource.success(successfulResponse)
    }

    return Resource.error(getException())
}

internal fun <DomainModel, Dto : BaseDto<DomainModel>> Response<Dto>.extractResultStraight(): Resource<DomainModel> {
    val successfulResponse = body()?.toDomainModel()

    if (isSuccessful && successfulResponse != null) {
        return Resource.success(successfulResponse)
    }

    return Resource.error(getException())
}

internal fun <DomainModel, Dto : BaseDto<DomainModel>> Response<BaseResponse<List<Dto>>>.extractListResult(): Resource<List<DomainModel>> {
    val successfulResponse = body()?.data?.map { it.toDomainModel() }

    if (isSuccessful && successfulResponse != null) {
        return Resource.success(successfulResponse)
    }

    return Resource.error(getException())
}
