package com.example.learnenglishapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnenglishapp.presentation.ui.screen.maindictionary.AddNewWordsScreen
import com.example.learnenglishapp.presentation.ui.screen.maindictionary.ForBeginnersScreen
import com.example.learnenglishapp.presentation.ui.screen.maindictionary.MainScreen
import com.example.learnenglishapp.presentation.ui.screen.maindictionary.YourListScreen
import com.example.learnenglishapp.presentation.ui.theme.LearnEnglishAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnEnglishAppTheme {
                ForBeginnersScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnEnglishAppTheme {
        Greeting("Android")
    }
}