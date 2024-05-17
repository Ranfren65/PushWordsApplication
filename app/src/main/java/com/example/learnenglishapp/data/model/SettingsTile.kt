package com.example.learnenglishapp.data.model

import android.graphics.Path.Direction

data class SettingsTile(
    val title:String,
    val parameter:String?=null,
    val direction:Direction?=null,
){
    companion object
}
