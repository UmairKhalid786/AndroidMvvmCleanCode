package com.techlad.android_mvvm_clean_code.di

import com.techlad.android_mvvm_clean_code.feature_sections.domain.repository.SectionsRepository
import com.techlad.android_mvvm_clean_code.feature_sections.domain.usecases.SectionsUseCase
import com.techlad.android_mvvm_clean_code.feature_sections.domain.usecases.GetSectionDetail
import com.techlad.android_mvvm_clean_code.feature_sections.domain.usecases.GetSectionsList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideSectionsUseCase(repository: SectionsRepository) = SectionsUseCase(
        getSectionDetail = GetSectionDetail(repository),
        getAllSections = GetSectionsList(repository)
    )
}