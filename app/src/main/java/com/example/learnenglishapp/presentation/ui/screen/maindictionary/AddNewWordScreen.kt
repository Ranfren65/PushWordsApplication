package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learnenglishapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNewWordsScreen() {
    Scaffold(
        topBar = {
            TopBarAddWords(backButtonAddWord = {},
                           closeAddWordScreen = {})
        },
        bottomBar = { BottomBar() }

    ) {
        AddWords(value = "Поиск") {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAddWords(
    backButtonAddWord: () -> Unit,
    closeAddWordScreen: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Добавление новых слов") },
        navigationIcon = {
            IconButton(onClick = backButtonAddWord) {
                Icon(
                    painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = "back",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = closeAddWordScreen) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close"
                )
            }
        }
    )
}

@Composable
fun AddWords(
    value: String,
    onValueChange: (String) -> Unit
) {
    val eng: String = "Английский"
    val rus: String = "Русский"
    var serch by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 100.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = eng)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.swap),
                        modifier = Modifier.size(35.dp),
                        contentDescription = null
                    )
                }
                Text(text = rus)
            }
            TextField(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(id = R.color.lightLightGray))
                    .fillMaxWidth()
                    .height(100.dp),
                value = serch,
                onValueChange = { serch = it },
                placeholder = { Text(text = "Поиск") },
                trailingIcon = {
                    if (serch.isNotEmpty())
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.vocal),
                                contentDescription = "vocalize",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                })
            Spacer(modifier = Modifier.height(25.dp))
            Text(modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Выберите основной перевод:",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(25.dp))
            ChipsWord()
            Spacer(modifier = Modifier.height(25.dp))
            Text(modifier = Modifier.fillMaxWidth(),
                 textAlign = TextAlign.Start,
                text = "Примеры",
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(modifier = Modifier.fillMaxWidth(),
                 textAlign = TextAlign.Start,
                 text = "Apple")
            Spacer(modifier = Modifier.height(25.dp))
            Text(modifier = Modifier.fillMaxWidth(),
                 textAlign = TextAlign.Start,
                text = "Яблоко",
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.appGreen),
                    contentColor = Color.Black

                ),


                onClick = { /*TODO*/ }) {
                Text(text = "Добавить в список")
            }

        }
    }
}

@Composable
fun ChipsWord() {
    Text(text = "Тут будут чипсы")
}