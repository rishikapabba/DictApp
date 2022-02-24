package com.example.test.dict_feature.data.repository.repos

import com.example.test.core.util.Resource
import com.example.test.dict_feature.data.local.DataAccessObj.WordInfoDAO
import com.example.test.dict_feature.data.remote.API.DictAPI
import com.example.test.dict_feature.domain.model.Word
import com.example.test.dict_feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordInfoRepositoryImpl(
    private val api: DictAPI,
    private val dao: WordInfoDAO
): WordInfoRepository{
    override fun getWordInfo(word: String): Flow<Resource<List<Word>>> = flow {
        emit(Resource.Loading())

        try{
            val remoteWordInfos=api.wordInfo(word)
            dao.deleteWords(remoteWordInfos.map{it.word})
            dao.insertWords(remoteWordInfos.map{it.toWordInfoEntity()})
        }catch(e: Exception){
            emit(Resource.Error(message="Error Occurred",data=dao.getWords(word).map{it.toWordInfo()}))
        }
        emit(Resource.Success(dao.getWords(word).map{it.toWordInfo()}))
    }
}


