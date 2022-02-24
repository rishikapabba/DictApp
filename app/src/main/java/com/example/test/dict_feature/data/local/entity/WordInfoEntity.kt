package com.example.test.dict_feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.test.dict_feature.domain.model.Meaning
import com.example.test.dict_feature.domain.model.Word

@Entity
data class WordInfoEntity(
    @PrimaryKey val id:Int? =null,
    val word: String,
    val phonetic: String?,
    val origin: String?,
    val meanings: List<Meaning>,

){
    fun toWordInfo(): Word {
        return Word(
            phonetic =phonetic,
            meanings = meanings,
            word =word,
            origin =origin

        )
    }
}
