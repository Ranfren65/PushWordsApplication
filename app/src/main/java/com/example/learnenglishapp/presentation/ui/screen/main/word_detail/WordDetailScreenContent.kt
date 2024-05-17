package com.example.learnenglishapp.presentation.ui.screen.main.word_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnenglishapp.R
import com.example.learnenglishapp.presentation.ui.components.AppBottomBar
import com.example.learnenglishapp.presentation.ui.components.CloseButton
import com.example.learnenglishapp.presentation.ui.screen.main.word_detail.components.WordTag

@Composable
fun WordDetailScreen(){
    WordDetailScreenContent(
        onCloseButtonClick = { /*TODO*/ },
        onShowOtherWordsButtonClick = { /*TODO*/ },
        word = FakeWord("","",listOf(""))
    )
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun WordDetailScreenContent(
    modifier: Modifier = Modifier,
    onCloseButtonClick: () -> Unit,
    onShowOtherWordsButtonClick: () -> Unit,
    word: FakeWord,
) {
    val tags = word.translationList
    val basicPadding = 20.dp
    Scaffold(
        bottomBar = {AppBottomBar()}
    ) { innerpadding->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .background(Color.White)
        ) {
            Box(modifier = Modifier.align(Alignment.TopEnd)) {
                CloseButton(
                    onCloseButtonClick = { onCloseButtonClick },
                    Modifier.align(Alignment.TopEnd),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 160.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = basicPadding),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        text = word.engWord,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 55.sp,
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = word.transcription,
                        color = Color.Gray,
                        fontSize = 19.sp,
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter= painterResource(id = R.drawable.voiceover),
                            contentDescription = ""
                        )
                    }
                }

                Spacer(modifier = Modifier.height(basicPadding))

                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val unvisibleTagsCount = tags.size - 5
                    if (tags.size >= 6) {
                        tags.take(5).forEach { tag ->
                            WordTag(tag = tag)
                        }
                        TextButton(onClick = { onShowOtherWordsButtonClick }) {
                            Text(
                                text = "еще " + unvisibleTagsCount,
                                color = Color.Gray,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(start = 30.dp)
                                    .align(
                                        Alignment.CenterVertically,
                                    )
                            )
                        }
                    } else {
                        tags.forEach { tag ->
                            WordTag(tag = tag)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    modifier = Modifier.padding(horizontal = basicPadding),
                    text = stringResource(R.string.examples),
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.height(basicPadding))

                Text(
                    modifier = Modifier.padding(horizontal = basicPadding),
                    fontSize = 18.sp,
                    text = "This parameter of the card component draws a border around the container of the card. We need to pass a BorderStroke to set border property. "
                )

                Spacer(modifier = Modifier.height(basicPadding))

                Text(
                    modifier = Modifier.padding(horizontal = basicPadding),
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.gray_200),
                    text = "This parameter of the card component draws a border around the container of the card. We need to pass a BorderStroke to set border property. "
                )
            }
        }
    }
}

@Composable
@Preview
private fun WordDetailScreenPreview() {
    val wordForExample = FakeWord(
        engWord = "Bag",
        transcription = "[baeg] сущ",
        translationList = listOf(
            "Сумка",
            "Чехол",
            "Сумочка",
            "Авоська",
            "Пакет",
            "Чехол",
            "Сумочка",
            "Авоська",
        )
    )
    WordDetailScreenContent(
        onCloseButtonClick = {},
        onShowOtherWordsButtonClick = {},
        word = wordForExample,
    )
}

data class FakeWord(
    val engWord: String,
    val transcription: String,
    val translationList: List<String>,
)
