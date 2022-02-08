package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.techlad.android_mvvm_clean_code.feature_sections.domain.dto.BaseDto
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.SubSection
import com.techlad.android_mvvm_clean_code.network.JsonKey

/**
 * Created by umair.khalid on 25,January,2022
 **/

@JsonClass(generateAdapter = true)
data class LinksDto(
    @Json(name = JsonKey.SECTIONS_PARAM)
    val sections: List<SubSectionDto>
) : BaseDto<List<SubSection>> {
    override fun toDomainModel() = sections.map { it.toDomainModel() }
}

