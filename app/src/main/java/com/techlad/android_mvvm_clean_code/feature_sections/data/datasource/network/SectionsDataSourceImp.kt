package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.network.SectionsApi
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section

/**
 * Created by umair.khalid on 25,January,2022
 **/

class SectionsDataSourceImp(private val nentApi: SectionsApi) : SectionsDataSource {
    override suspend fun getSections(url: String) : Resource<Section> = nentApi.getSections(appendBackslash(url)).extractResultStraight()

    private fun appendBackslash(url: String) = if(url.isNotBlank()) url else ""
}