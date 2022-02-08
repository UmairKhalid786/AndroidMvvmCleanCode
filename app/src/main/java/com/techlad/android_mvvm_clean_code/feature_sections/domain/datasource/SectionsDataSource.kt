package com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section

/**
 * Created by umair.khalid on 25,January,2022
 **/

interface SectionsDataSource {
    suspend fun getSections(url: String): Resource<Section>
}