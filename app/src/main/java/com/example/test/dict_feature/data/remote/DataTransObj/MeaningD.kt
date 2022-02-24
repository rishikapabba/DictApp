package com.example.test.dict_feature.data.remote.dto

import com.example.test.dict_feature.domain.model.Meaning

data class MeaningD(
    val definitions: List<DefinitionD>,
    val partOfSpeech: String
){
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map{ it.toDefinition() },
            partOfSpeech= partOfSpeech
        )
    }
}
