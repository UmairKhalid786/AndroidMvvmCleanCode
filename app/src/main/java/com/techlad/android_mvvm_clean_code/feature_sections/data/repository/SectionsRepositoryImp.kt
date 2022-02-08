package com.techlad.android_mvvm_clean_code.feature_sections.data.repository

import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.fetchSectionInDomain
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.insertSectionFromDomain
import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource.Companion.loading
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.SectionsDataSource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SubSectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.repository.SectionsRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by umair.khalid on 25,January,2022
 **/

class SectionsRepositoryImp @Inject constructor(
    private val networkSource: SectionsDataSource,
    private val sectionsDao: SectionsDao,
    private val subSectionsDao: SubSectionsDao,
) : SectionsRepository {

    override suspend fun getSectionDetail(url: String) = flow {
        emit(loading())

        val db = try {
            networkSource.getSections(url).also {
                if (it.status == Resource.Status.ERROR) {
                    emit(it)
                } else {
                    sectionsDao.insertSectionFromDomain(url, it.data)
                }
            }
            sectionsDao.fetchSectionInDomain(url)
        } catch (e: Exception) {
            sectionsDao.fetchSectionInDomain(url)
        }

        emitAll(db)
    }.flowOn(Dispatchers.IO)

    override suspend fun getSectionsList() = flow {
        emit(loading())

        val db = try {
            networkSource.getSections("").also {
                if (it.status == Resource.Status.ERROR) {
                    emit(it)
                } else {
                    subSectionsDao.insertSectionFromDomain(it.data)
                }
            }
            subSectionsDao.fetchSectionInDomain()
        } catch (e: Exception) {
            subSectionsDao.fetchSectionInDomain()
        }
        emitAll(db)
    }.flowOn(Dispatchers.IO)
}