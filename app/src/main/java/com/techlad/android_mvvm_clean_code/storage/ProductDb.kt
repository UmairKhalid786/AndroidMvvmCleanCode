package com.techlad.android_mvvm_clean_code.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SectionEntity
import com.techlad.android_mvvm_clean_code.feature_sections.data.datasource.db.model.SubSectionEntity
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SectionsDao
import com.techlad.android_mvvm_clean_code.feature_sections.domain.datasource.db.dao.SubSectionsDao

/**
 * Created by umair.khalid on 25,January,2022
 **/


@Database(
    entities = [SectionEntity::class, SubSectionEntity::class],
    version = ProductDb.VERSION,
    exportSchema = false
)
abstract class ProductDb : RoomDatabase() {

    abstract fun sectionsDao(): SectionsDao
    abstract fun subSectionsDao(): SubSectionsDao

    companion object {
        internal const val VERSION = 1
        private const val NAME = "nent_db"

        fun create(applicationContext: Context): ProductDb {
            return Room.databaseBuilder(
                applicationContext,
                ProductDb::class.java,
                NAME
            ).build()
        }
    }
}