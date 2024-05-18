package com.example.learnenglishapp.presentation.ui.screen.repeatList

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.MyViewModel
import com.example.learnenglishapp.presentation.ui.components.WordInfo
import com.example.learnenglishapp.presentation.ui.screen.maindictionary.BottomBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun RepeatScreen(
    vm: MyViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            if (vm.listWords.isEmpty()) {
                BottomBar()
            } else null
        }
    ) {
        if (vm.listWords.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.no_words_repeat),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        } else {
            if (vm.numbers.value >  vm.size) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.good_job),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(top = 20.dp),
                            text = stringResource(R.string.you_repeat_all),
                            fontSize = 20.sp
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, start = 15.dp, end = 15.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.button_green)
                            ),
                            onClick = { /*TODO*/ }) {
                            Text(
                                text = stringResource(R.string.close),
                                color = Color.Black
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background((colorResource(id = R.color.background_repeat)))
                ) {
                    LazyColumn {
                        item {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            ) {
                                Text(
                                    text = "${vm.numbers.value} из ${vm.size}",
                                    fontSize = 20.sp
                                )
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "close",
                                        tint = Color.Black,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(100.dp))
                            Box(modifier = Modifier.fillMaxWidth()) {
                                if (vm.isOpen) {
                                    WordInfo(words = vm.w.russianWord)
                                } else {
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = vm.w.englishWor,
                                            fontSize = 30.sp
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(top = 10.dp),
                                            text = "[baeg] сущ",
                                            color = Color.Gray
                                        )
                                        IconButton(modifier = Modifier
                                            .padding(top = 10.dp),
                                                   onClick = { /*TODO*/ }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.vocalize),
                                                contentDescription = "vocalize"
                                            )
                                        }

                                    }
                                    Spacer(modifier = Modifier.height(575.dp))
                                }
                            }
                        }
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    IconButton(modifier = Modifier.size(60.dp),
                                               onClick = { /*TODO*/ }) {
                                        Icon(
                                            modifier = Modifier.size(60.dp),
                                            painter = painterResource(id = R.drawable.arrow__left),
                                            contentDescription = "left"
                                        )
                                    }
                                    Text(text = stringResource(R.string.forgot))
                                }
                                IconButton(onClick = { vm.isOpen = !vm.isOpen }) {
                                    if (vm.isOpen) {
                                        Icon(
                                            modifier = Modifier.size(30.dp),
                                            painter = painterResource(id = R.drawable.eye_off),
                                            contentDescription = "eye"
                                        )
                                    } else
                                        Icon(
                                            modifier = Modifier.size(30.dp),
                                            painter = painterResource(id = R.drawable.eye),
                                            contentDescription = "eye"
                                        )
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(modifier = Modifier.size(60.dp),
                                               onClick = {
                                                   scope.launch {
                                                       (vm.numbers.value++)}
                                               }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.arrow__right),
                                            contentDescription = "right",
                                            modifier = Modifier.size(60.dp)
                                        )

                                    }
                                    Text(text = stringResource(R.string.remember))

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


