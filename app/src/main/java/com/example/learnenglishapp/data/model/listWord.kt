package com.example.learnenglishapp.data.model


data class ListWords (
    val englishWor:String,
    val russianWord:String,
    var playButton:Boolean = false,
    var checkSelected:Boolean=true
    )
