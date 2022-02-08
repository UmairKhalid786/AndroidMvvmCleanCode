package com.techlad.android_mvvm_clean_code.di

import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.network.SectionsDataSourceImp
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.network.SectionsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApisModule {

    @Singleton
    @Provides
    fun provideSectionsApi(retrofit: Retrofit) : SectionsApi = retrofit.create(SectionsApi::class.java)

    @Singleton
    @Provides
    fun provideSectionsDataSource(
        api: SectionsApi,
    ): SectionsDataSource = SectionsDataSourceImp(nentApi = api)
}
