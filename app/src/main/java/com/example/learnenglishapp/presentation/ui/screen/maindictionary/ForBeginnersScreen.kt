package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.ListWords
import com.example.learnenglishapp.data.model.MyViewModel
import com.example.learnenglishapp.presentation.ui.components.WordCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ForBeginnersScreen(
    vm: MyViewModel = viewModel()
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
            ListsWords(
                listWord = vm.listWords
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    backButton: () -> Unit,

    ) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.top_3000),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.for_beginners),
                    fontSize = 20.sp
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { backButton }) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "back",
                    modifier = Modifier.size(20.dp)

                )
            }
        },

        )
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ListsWords(
    listWord: List<ListWords>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
        items(listWord) { item ->
            WordCard(
                listWords = item,
                checkClickButton =
                { },
            )
            Divider(
                color = colorResource(id = R.color.lightGray)
            )
        }
    }

}

