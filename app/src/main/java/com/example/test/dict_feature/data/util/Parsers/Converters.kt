package com.example.test.dict_feature.data.util.Parsers

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.test.dict_feature.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters (private val jsonParser: JsonParser){
    @TypeConverter
    fun toJasonFromMeanings(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object: TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsFromJason(meanings:List<Meaning>):String{
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }
}