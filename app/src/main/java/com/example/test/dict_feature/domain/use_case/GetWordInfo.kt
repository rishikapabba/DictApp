package com.example.test.dict_feature.domain.use_case
import com.example.test.core.util.Resource
import com.example.test.dict_feature.domain.model.Word
import com.example.test.dict_feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word:String): Flow<Resource<List<Word>>>{
        if(word.isBlank()){
            //getAllWords()
            return flow{ }
        }
        return repository.getWordInfo(word)
    }
}