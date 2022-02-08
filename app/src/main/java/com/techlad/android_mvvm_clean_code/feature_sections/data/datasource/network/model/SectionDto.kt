package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.techlad.android_mvvm_clean_code.feature_sections.domain.dto.BaseDto
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section
import com.techlad.android_mvvm_clean_code.network.JsonKey

/**
 * Created by umair.khalid on 25,January,2022
 **/

@JsonClass(generateAdapter = true)
data class SectionDto(
    @Json(name = JsonKey.SECTION_ID_PARAM)
    val sectionId: String?,
    @Json(name = JsonKey.TITLE_PARAM)
    val title: String,
    @Json(name = JsonKey.PAGE_TYPE_PARAM)
    val pageType: String,
    @Json(name = JsonKey.DESCRIPTION_PARAM)
    val description: String,
    @Json(name = JsonKey.LINKS_PARAM)
    val links: LinksDto,
) : BaseDto<Section> {
    override fun toDomainModel() = Section(
        sectionId = sectionId,
        title = title,
        description = description,
        pageType = pageType,
        sections = links.toDomainModel()
    )
}
