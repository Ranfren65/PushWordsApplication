package com.example.learnenglishapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.Events
import com.example.learnenglishapp.data.model.ListWords
import com.example.learnenglishapp.data.model.MyViewModel


@Composable
fun WordCard(
    listWords: ListWords,
    vm: MyViewModel = viewModel(),
    onEvent:(Events)->Unit
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
            .clickable { }
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
            IconButton(onClick =
                       { playButton = !playButton }
            ) {
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
                onEvent(Events.onClickCheck(clickCheck = !checkSelected))
                checkSelected = !checkSelected
            }

            ) {
                if (checkSelected && !playButton) {
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