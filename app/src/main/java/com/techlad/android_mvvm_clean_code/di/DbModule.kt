package com.techlad.android_mvvm_clean_code.di

import android.content.Context
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SubSectionsDao
import com.techlad.android_mvvm_clean_code.storage.ProductDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    fun provideDb(@ApplicationContext context: Context) = ProductDb.create(context)

    @Provides
    fun provideSectionsDao(productDb: ProductDb): SectionsDao = productDb.sectionsDao()

    @Provides
    fun provideSubSectionsDao(productDb: ProductDb): SubSectionsDao = productDb.subSectionsDao()
}