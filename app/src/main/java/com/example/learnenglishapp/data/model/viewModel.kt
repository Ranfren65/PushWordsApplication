package com.example.learnenglishapp.data.model

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions

@SuppressLint("MutableCollectionMutableState")
class MyViewModel: ViewModel(

){
    val items = mutableListOf(
        chipsWords(chip = "a"),
        chipsWords(chip = "s"),
        chipsWords(chip = "d"),
        chipsWords(chip = "f"),
        chipsWords(chip = "g"),
        chipsWords(chip = "o"),
        chipsWords(chip = "h"),
        chipsWords(chip = "j"),
        chipsWords(chip = "p"),
    )
    var indexChips by mutableStateOf(0)



    val listWords = mutableListOf(
        ListWords(
            englishWor = "Apple",
            russianWord = "Яблоко"
        ),
        ListWords(
            englishWor = "Big blue bag",
            russianWord = "Большая синяя сумка"
        ),
        ListWords(
            englishWor = "Table",
            russianWord = "Стол"
        ),)




    val repeatList = mutableListOf(
        ListWords(
            englishWor = "Apple",
            russianWord = "Яблоко"
        ),
        ListWords(
            englishWor = "Big blue bag",
            russianWord = "Большая синяя сумка"
        ),
        ListWords(
            englishWor = "Table",
            russianWord = "Стол"
        ),)
    var w by mutableStateOf(repeatList[0])
    var numbers = mutableStateOf(1)
    val size = repeatList.size
    var isOpen by mutableStateOf(false)




    private val _state = mutableStateOf(AddScreenState())
    val state:State<AddScreenState> = _state

    fun onTextToBeTranslatedChange(text:String){
        _state.value = state.value.copy(
            textToBeTranslated = text
        )
    }
    fun onTranslateButtonClick(
        text: String,
        context: Context
    ){
        val options = TranslatorOptions
            .Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
      //      .setSourceLanguage(TranslateLanguage.RUSSIAN)
            .setTargetLanguage(TranslateLanguage.RUSSIAN)
          //  .setTargetLanguage(TranslateLanguage.ENGLISH)
            .build()

        val languageTranslator = Translation
            .getClient(options)

        languageTranslator.translate(text)
            .addOnSuccessListener { translatedText->
                _state.value=state.value.copy(
                    translatedText = translatedText
                )
            }
            .addOnFailureListener{
                Toast.makeText(
                    context,
                    "Downloading started",
                    Toast.LENGTH_SHORT
                ).show()
                downloadModelIfNotAvailable(languageTranslator, context)
            }
    }

    private fun downloadModelIfNotAvailable(
        languageTranslator: Translator,
        context: Context
    ){

        val conditions = DownloadConditions
            .Builder()
            .build()

        languageTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Succesfull",
                    Toast.LENGTH_SHORT
                ).show()


            }
            .addOnFailureListener{
                Toast.makeText(
                    context,
                    "Some error",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }}







