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
data class SubSectionDto(
    @Json(name = JsonKey.ID_PARAM)
    val id: String,
    @Json(name = JsonKey.TITLE_PARAM)
    val title: String,
    @Json(name = JsonKey.HREF_PARAM)
    val href: String
) : BaseDto<SubSection> {
    override fun toDomainModel(): SubSection {
        return SubSection(
            id = id,
            title = title,
            href = href
        )
    }
}
