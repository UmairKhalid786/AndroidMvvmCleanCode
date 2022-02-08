package com.techlad.android_mvvm_clean_code.di

import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.data.repository.SectionsRepositoryImp
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SubSectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.repository.SectionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun provideDevicesRepository(
        dataSourceModule: SectionsDataSource,
        sectionDto: SectionsDao,
        subSectionsDao: SubSectionsDao,
    ): SectionsRepository =
        SectionsRepositoryImp(networkSource = dataSourceModule,
            sectionsDao = sectionDto,
            subSectionsDao = subSectionsDao)
}