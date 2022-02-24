package com.example.test.dict_feature.data.remote.API
import com.example.test.dict_feature.data.remote.dto.WordInfoD
import retrofit2.http.GET
import retrofit2.http.Path

interface DictAPI {
    @GET("/api/v2/entries/en/{word}")
    suspend fun wordInfo(
        @Path("word") word: String
    ): List<WordInfoD>
    companion object{
        const val BASE_URL="https://api.dictionaryapi.dev"
    }
}
