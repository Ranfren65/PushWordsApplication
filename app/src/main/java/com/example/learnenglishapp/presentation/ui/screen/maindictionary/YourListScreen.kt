package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.learnenglishapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun YourListScreen() {
    Scaffold(
        topBar = {
            TopBarYourList(
                addWordButton = {},
                backButtonYourList = {}
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
fun TopBarYourList(
    backButtonYourList: () -> Unit,
    addWordButton: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.your_own_list)) },
        navigationIcon = {
            IconButton(onClick = backButtonYourList) {
                Icon(
                    painter = painterResource(id = R.drawable.backbutton),
                    contentDescription = "back",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = addWordButton) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Outlined.AddCircle,
                    tint = colorResource(id = R.color.appGreen),
                    contentDescription = "Add word"
                )
            }
        }

    )
}
