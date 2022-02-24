package com.example.test.dict_feature.domain.repository

import com.example.test.core.util.Resource
import com.example.test.dict_feature.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word : String): Flow<Resource<List<Word>>>
}