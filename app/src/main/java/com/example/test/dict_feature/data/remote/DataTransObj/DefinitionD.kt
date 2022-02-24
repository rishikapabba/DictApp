package com.example.test.dict_feature.data.remote.dto

data class DefinitionD(
    val definition: String,
    val example: String?,
    val antonyms: List<String>?,
    val synonyms: List<String>?
){
    fun toDefinition(): DefinitionD{
        return DefinitionD(
            definition=definition,
            example=example,
            antonyms=antonyms,
            synonyms=synonyms
        )
    }
}