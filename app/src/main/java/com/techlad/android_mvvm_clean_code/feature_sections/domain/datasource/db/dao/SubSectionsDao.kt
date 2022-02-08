package com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SubSectionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Dao
interface SubSectionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(section: SubSectionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(section: List<SubSectionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(section: SubSectionEntity)

    @Query("SELECT * FROM SubSectionEntity WHERE href= :href")
    fun getSectionByHref(href:  String): Flow<SubSectionEntity?>

    @Query("SELECT * FROM SubSectionEntity")
    fun getAll(): Flow<List<SubSectionEntity>?>
}