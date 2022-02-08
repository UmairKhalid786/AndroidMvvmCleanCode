package com.techlad.android_mvvm_clean_code.feature_sections.domain.usecases

import com.techlad.android_mvvm_clean_code.feature_sections.domain.repository.SectionsRepository

/**
 * Created by umair.khalid on 25,January,2022
 **/

class GetSectionsList(private val repository: SectionsRepository) {
    suspend operator fun invoke() = repository.getSectionsList()
}