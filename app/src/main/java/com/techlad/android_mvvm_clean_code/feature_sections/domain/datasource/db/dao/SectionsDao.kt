package com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SectionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Dao
interface SectionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(section: SectionEntity)


    @Query("SELECT * FROM SectionEntity WHERE sectionId =:sectionId")
    fun getSectionById(sectionId: String): Flow<SectionEntity?>

    @Query("SELECT * FROM SectionEntity WHERE href =:href")
    fun getSectionByHref(href: String): Flow<SectionEntity?>
}