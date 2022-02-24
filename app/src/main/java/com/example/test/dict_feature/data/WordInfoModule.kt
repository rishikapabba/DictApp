package com.example.test.dict_feature.data

import android.app.Application
import androidx.room.Room
import com.example.test.dict_feature.data.local.WordInfoDatabase
import com.example.test.dict_feature.data.remote.API.DictAPI
import com.example.test.dict_feature.data.repository.repos.WordInfoRepositoryImpl
import com.example.test.dict_feature.data.util.Parsers.Converters
import com.example.test.dict_feature.data.util.Parsers.GsonParser
import com.example.test.dict_feature.domain.repository.WordInfoRepository
import com.example.test.dict_feature.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideUseCase(repository:WordInfoRepository):GetWordInfo{
        return GetWordInfo(repository)
    }
    @Provides
    @Singleton
    fun provideRepo(db: WordInfoDatabase,
                    api: DictAPI
    ):WordInfoRepository{
        return WordInfoRepositoryImpl(api,db.dao)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application,
    ): WordInfoDatabase {
        return Room.databaseBuilder(
            app,WordInfoDatabase::class.java,"wrddb"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }
    @Provides
    @Singleton
    fun provideDIctApi(): DictAPI {
        return Retrofit.Builder()
            .baseUrl(DictAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictAPI::class.java)
    }

}