package com.example.test.dict_feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.dict_feature.domain.model.Word

@Composable
fun WordInfoItem(
    wordInfo:Word
){
    Column(modifier = Modifier.fillMaxSize()){
        Text(
            text=wordInfo.word,
            fontWeight= FontWeight.ExtraBold,
            fontSize = 30.sp
        )
        wordInfo.phonetic?.let {
            Text(
                text= it,
                fontWeight= FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier=Modifier.height(13.dp))
        wordInfo.origin?.let {
            Text(
                text= it
            )
        }
        wordInfo.meanings.forEach{ meaning ->
            Text(
                text = meaning.partOfSpeech,
                fontWeight= FontWeight.Bold
            )
            meaning.definitions.forEachIndexed { index, definition ->
                Text(text="${index+1}.${definition.definition}")
                Spacer(modifier=Modifier.height(10.dp))
                definition.example?.let{
                        example ->
                    Text(text="Example: $example",fontStyle = FontStyle.Italic,fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}