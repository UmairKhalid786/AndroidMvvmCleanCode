package com.techlad.android_mvvm_clean_code.feature_sections.domain.dto

interface BaseDto<Any> {
    fun toDomainModel(): Any
}
