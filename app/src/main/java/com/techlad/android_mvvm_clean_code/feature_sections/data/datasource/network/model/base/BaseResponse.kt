package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.model.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.techlad.android_mvvm_clean_code.network.JsonKey

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = JsonKey.LINKS_PARAM)
    val data: T?
)
