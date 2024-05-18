package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.learnenglishapp.data.model.Events
import com.example.learnenglishapp.data.model.ListWords
import com.example.learnenglishapp.data.model.MyViewModel
import com.example.learnenglishapp.presentation.ui.components.WordCard
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ForBeginnersScreen(
    vm: MyViewModel = viewModel()
) {
    var isOpen by remember {
        mutableStateOf(false)
    }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                modifier = Modifier.fillMaxWidth(),
                hostState = snackbarHostState) { data:SnackbarData ->
                Snackbar (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    containerColor = colorResource(id = R.color.yellow_)
                ){
                    Text(
                        modifier = Modifier.padding(start = 90.dp),
                        text = stringResource(id = R.string.add_learning),
                         textAlign = TextAlign.Center,
                         color = Color.Black
                    )
                }
            }
        },
        topBar = {
            TopBar(
                backButton = {}
            )
        },
        bottomBar = { BottomBar() }
    ) {
        Column {
            ListsWords(
                listWord = vm.listWords,
                onEvent = { events ->
                    when (events) {
                        is Events.onClickCheck -> {
                            if (events.clickCheck) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("")

                                }
                            }
                        }
                    }
                }
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
    listWord: List<ListWords>,
    onEvent:(Events)->Unit
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
                onEvent = onEvent
                )
            Divider(
                color = colorResource(id = R.color.lightGray)
            )
        }
    }

}

