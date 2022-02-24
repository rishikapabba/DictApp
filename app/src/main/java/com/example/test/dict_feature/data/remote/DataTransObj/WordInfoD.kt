package com.example.test.dict_feature.data.remote.dto
import com.example.test.dict_feature.data.local.entity.WordInfoEntity

data class WordInfoD(
    val meanings: List<MeaningD>,
    val phonetic: String?,
    val phonetics: List<PhoneticD>,
    val word: String,
    val origin: String?
){
    fun toWordInfoEntity(): WordInfoEntity{
        return WordInfoEntity(
            phonetic =phonetic,
            meanings = meanings.map { it.toMeaning() },
            word =word,
            origin = origin
        )
    }
}
