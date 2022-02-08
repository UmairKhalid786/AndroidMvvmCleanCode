package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db

import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SectionEntity
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SubSectionEntity
import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SubSectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section
import com.techlad.android_mvvm_clean_code.utils.lastSegment
import com.techlad.android_mvvm_clean_code.utils.removeDtg
import kotlinx.coroutines.flow.map

/**
 * Created by umair.khalid on 25,January,2022
 **/


fun SectionsDao.fetchSectionInDomain(url: String) =
    getSectionByHref(url).map { it?.toDomainModel() }
        .map { it?.let { Resource.success(it) } ?: error("") }

suspend fun SectionsDao.insertSectionFromDomain(url: String, section: Section?) {
    section?.let {
        section.sectionId?.let {
            insert(SectionEntity(
                href = url,
                sectionId = section.sectionId,
                pageType = section.pageType,
                title = section.title,
                description = section.description))
        }
    }
}


fun SubSectionsDao.fetchSectionInDomain() =
    getAll().map { it?.map { it.toDomainModel() } }.map {
        it?.let {
            Resource.success(
                Section(null, "Viaplay",
                    "root",
                    "metadata",
                    sections = it)
            )
        } ?: error("")
    }

suspend fun SubSectionsDao.insertSectionFromDomain(subSection: Section?) {
    subSection?.let {
        insertAll(it.sections.map {
            SubSectionEntity(it.id,
                it.title,
                it.href.lastSegment().removeDtg())
        })
    }
}