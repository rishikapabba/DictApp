package com.example.test.dict_feature.presentation

import com.example.test.dict_feature.domain.model.Word

data class WordInfoState(
    val wordInfoItems: List<Word> = emptyList(),
    val isLoading:Boolean = false
)
