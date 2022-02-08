package com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Entity
class SectionEntity(
    @PrimaryKey
    val sectionId: String = "root",
    val title: String,
    val pageType: String,
    val description: String,
    val href: String,
) {
    fun toDomainModel() = Section(sectionId = sectionId, title = title, pageType = pageType, description = description, listOf())
}