package com.example.learnenglishapp.data.model

sealed class Events {
    data class onClickCheck(
        var clickCheck:Boolean
    ):Events()
}