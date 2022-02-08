package com.techlad.android_mvvm_clean_code.feature_sections.data.repository

import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.repository.SectionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SectionsRepositoryImpTest(private val sectionsDataSource: SectionsDataSource) :
    SectionsRepository {

    var testingForSuccess = true
    override suspend fun getSectionDetail(url: String) = flow {
        emit(if (testingForSuccess) sectionsDataSource.getSections(url) else Resource.error(
            Exception("Something went wrong")))
    }.flowOn(Dispatchers.IO)

    override suspend fun getSectionsList() = flow {
        emit(if (testingForSuccess) sectionsDataSource.getSections("") else Resource.error(
            Exception("Something went wrong")))
    }
}