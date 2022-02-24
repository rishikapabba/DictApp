package com.example.test.dict_feature.domain.model

import com.example.test.dict_feature.data.remote.dto.DefinitionD

data class Meaning(
    val definitions: List<DefinitionD>,
    val partOfSpeech: String
)