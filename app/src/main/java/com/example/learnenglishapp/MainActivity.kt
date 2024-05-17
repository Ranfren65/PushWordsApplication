package com.example.learnenglishapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learnenglishapp.presentation.ui.theme.LearnEnglishAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnEnglishAppTheme {

            }
        }
    }
}
