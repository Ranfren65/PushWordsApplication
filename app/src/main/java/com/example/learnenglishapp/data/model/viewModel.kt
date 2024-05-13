package com.example.learnenglishapp.data.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel(){
    val items = mutableListOf(
        chipsWords(chip = "a"),
        chipsWords(chip = "s"),
        chipsWords(chip = "d"),
        chipsWords(chip = "f"),
        chipsWords(chip = "g"),
        chipsWords(chip = "h"),
        chipsWords(chip = "h"),
        chipsWords(chip = "j")
    )
    var indexChips by mutableStateOf(items[0])

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
        ),

    )
    var valuecheck by mutableStateOf(0)
    var playCheck by mutableStateOf(false)
    var valueButton by mutableStateOf(0)
    var playButton by mutableStateOf(false)
        fun coun(i:ListWords){
            if (playCheck)
            {
                i.copy(checkSelected = true)
            }
        }

    fun playbut(play:ListWords){
        if (playButton){
            play.copy(checkSelected = true)
        }
    }
}
