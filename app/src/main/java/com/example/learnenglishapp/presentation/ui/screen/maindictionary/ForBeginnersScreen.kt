package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.ListWords

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForBeginnersScreen(

) {

    Scaffold(
        topBar = {
            TopBar(
                backButton = {}
            )
        },
        bottomBar = { BottomBar() }

    ) {
        Column {
            ListsWords()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    backButton: () -> Unit,

    ) {
    TopAppBar(
        title = {
            Row {
                Text(text = stringResource(R.string.top_3000))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = stringResource(R.string.for_beginners))
            }
        },
        navigationIcon = {
            IconButton(onClick = { backButton }) {
                Icon(
                    painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = "back",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
        },

        )
}


@Composable
fun WordCard(
    listWords: ListWords,
    checkClickButton: () -> Unit
) {
    var playButton by remember {
        mutableStateOf(false)
    }
    var checkSelected by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (playButton) colorResource(id = R.color.lightLightGray)
                else Color.Transparent
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, bottom = 10.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.Start,
                text = listWords.englishWor
            )
            Spacer(modifier = Modifier.weight(0.3f))
            Text(
                modifier = Modifier.weight(0.5f),
                textAlign = TextAlign.Center,
                text = listWords.russianWord
            )
            IconButton(onClick = {
                playButton = !playButton
            }) {
                if (playButton) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        tint = colorResource(id = R.color.appGreen),
                        contentDescription = "play"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.PlayArrow,
                        contentDescription = "play"
                    )
                }
            }
            IconButton(onClick = {
                checkClickButton()
                checkSelected = !checkSelected
            }

            ) {
                if (checkSelected) {
                    Icon(
                        imageVector = Icons.Outlined.Done,
                        tint = Color.Green,
                        contentDescription = "done"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Done,
                        contentDescription = "done"
                    )
                }
            }

        }


    }
}


@Composable
fun ListsWords(

) {
    val items = listOf(
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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        item {
            Spacer(modifier = Modifier.height(80.dp))
            Divider()
        }
        item {
            items.forEachIndexed { index, listWords ->
                WordCard(
                    listWords = listWords,
                    checkClickButton = {},

                    )
                Divider()
            }
        }
    }
}