package com.example.learnenglishapp.presentation.ui.screen.maindictionary

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.learnenglishapp.data.model.MyViewModel
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun YourListScreen(vm: MyViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                modifier = Modifier.fillMaxWidth(),
                hostState = snackbarHostState) { data: SnackbarData ->
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
            TopBarYourList(
                addWordButton = {},
                backButtonYourList = {}
            )
        },
        bottomBar = { BottomBar() }

    ) {
        Column {
           ListsWords( listWord = vm.listWords,
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
                       })
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarYourList(
    backButtonYourList: () -> Unit,
    addWordButton: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.your_own_list),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = backButtonYourList) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "back",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)

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
