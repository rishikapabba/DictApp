package com.example.test.dict_feature.data.local.DataAccessObj

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.test.dict_feature.data.local.entity.WordInfoEntity

@Dao
interface WordInfoDAO {

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWords(words: List<String>)

    @Query("SELECT * FROM wordinfoentity WHERE word = :word")
    suspend fun  getWords(word:String): List<WordInfoEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertWords(info: List<WordInfoEntity>)

    @Update
    suspend fun updateWords(i: List<WordInfoEntity>)
}