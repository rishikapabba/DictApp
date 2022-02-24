package com.example.test.dict_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.test.dict_feature.data.local.DataAccessObj.WordInfoDAO
import com.example.test.dict_feature.data.local.entity.WordInfoEntity
import com.example.test.dict_feature.data.util.Parsers.Converters

@Database(
    entities=[WordInfoEntity::class],
    version=1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {
    abstract val dao: WordInfoDAO
}