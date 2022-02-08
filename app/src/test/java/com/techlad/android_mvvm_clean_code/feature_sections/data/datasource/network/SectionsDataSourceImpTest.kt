package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.SubSection


class SectionsDataSourceImp : SectionsDataSource {

    private val section = Section(
        sectionId = "1229",
        title = "Section",
        pageType = "page",
        description = "Dummy Section",
        sections = listOf(SubSection("1", "a", "url"))
    )

    override suspend fun getSections(url: String): Resource<Section> {
        return Resource.success(section)
    }
}