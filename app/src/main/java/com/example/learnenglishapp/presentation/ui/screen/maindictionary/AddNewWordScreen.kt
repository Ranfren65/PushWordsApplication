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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.MyViewModel
import com.example.learnenglishapp.data.model.chipsWords

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNewWordsScreen(

) {
    Scaffold(
        topBar = {
            TopBarAddWords(backButtonAddWord = {},
                           closeAddWordScreen = {})
        }
    ) {
        AddWords()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarAddWords(
    backButtonAddWord: () -> Unit,
    closeAddWordScreen: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.add_new_words),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = backButtonAddWord) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "back",
                    modifier = Modifier.size(20.dp)

                )
            }
        },
        actions = {
            IconButton(onClick = closeAddWordScreen) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}

@Composable
private fun AddWords(

    vm: MyViewModel = viewModel()
) {
    var less by remember {
        mutableStateOf(true)
    }
    var eng by remember {
        mutableStateOf("Английский")
    }
    val rus by remember {
        mutableStateOf("Русский")
    }
    var serch by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 100.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.weight(0.4f),
                    contentAlignment = Alignment.Center
                ) {
                    if (less) {
                        Text(
                            text = eng,
                            fontSize = 20.sp
                        )
                    } else {
                        Text(
                            text = rus,
                            fontSize = 20.sp
                        )
                    }
                }

                IconButton(
                    modifier = Modifier.weight(0.2f),
                    onClick = {
                        less = !less
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.swap),
                        modifier = Modifier.size(35.dp),
                        contentDescription = null
                    )
                }
                Box(
                    modifier = Modifier.weight(0.4f),
                    contentAlignment = Alignment.Center
                ) {
                    if (less) {
                        Text(
                            text = rus,
                            fontSize = 20.sp
                        )
                    } else {
                        Text(
                            text = eng,
                            fontSize = 20.sp
                        )
                    }
                }
            }

            TextField(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(id = R.color.background_field))
                    .fillMaxWidth()
                    .height(100.dp),
                value = serch,
                onValueChange = { serch = it },
                placeholder = { Text(text = stringResource(R.string.search)) },
                trailingIcon = {
                    if (serch.isNotEmpty())
                        IconButton(
                            onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.vocalize),
                                contentDescription = "vocalize",
                                tint = Color.Black,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                })

            Spacer(modifier = Modifier.height(25.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = stringResource(R.string.select_translation),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(25.dp))
            Chips(
                chip = vm.items
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = stringResource(R.string.examples),
                fontStyle = FontStyle.Italic,
                color = Color.Gray,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Apple"
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Яблоко",
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth(),
                   shape = RoundedCornerShape(10.dp),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = colorResource(id = R.color.button_green),
                       disabledContainerColor = Color.Gray,
                       contentColor = Color.Black

                   ),

                   onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.add_tolist))
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Chips(
    vm: MyViewModel = viewModel(),
    chip: List<chipsWords>
) {
    LazyRow {
        items(chip) {
            InputChip(
                modifier = Modifier
                    .width(50.dp)
                    .height(20.dp),
                selected = vm.indexChips == it,
                onClick = {
                    vm.indexChips = it
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = colorResource(id = R.color.yellow_),
                    disabledContainerColor = colorResource(id = R.color.background_chips),

                    ),
                label = { Text(text = it.chip) })
        }
    }
}


