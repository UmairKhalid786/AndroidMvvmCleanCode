package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.model.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.techlad.android_mvvm_clean_code.network.JsonKey

@JsonClass(generateAdapter = true)
internal data class ErrorResponse(
    @Json(name = JsonKey.MESSAGE_PARAM)
    val message: String,
    @Json(name = JsonKey.SUCCESS_PARAM)
    val success: String,
    @Json(name = JsonKey.CODE_PARAM)
    val code: Int
)
