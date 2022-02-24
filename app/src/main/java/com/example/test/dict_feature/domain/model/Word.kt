package com.example.test.dict_feature.domain.model

data class Word(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val word: String,
    val origin: String?
)
