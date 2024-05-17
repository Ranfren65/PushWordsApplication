package com.example.learnenglishapp.presentation.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.Category
import com.example.learnenglishapp.presentation.ui.components.AppBottomBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    MainScreenContent(
        onCategoryCardClick = {},
        onSettingsButtonClick = {},
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    onCategoryCardClick: () -> Unit,
    onSettingsButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(
                onSettingsButtonClick = onSettingsButtonClick
            )
        },
        bottomBar = { AppBottomBar() }
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                CategoryGroup(
                    onCategoryCardClick = onCategoryCardClick
                )
            }
        }
    }
}
/* Для другого экрана
@Composable
private fun WordsTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        placeholder = {
            Text(
                text = stringResource(R.string.text),
                modifier = Modifier
                    .height(30.dp)
                    .alpha(0.7f)
            )
        },
        modifier = Modifier.fillMaxWidth(0.93f),
        value = value,
        onValueChange = {
            onValueChange
        },
        singleLine = true,
    )
*/

@Composable
private fun CategoryCardItem(
    modifier: Modifier = Modifier,
    category: Category,
    onCategoryCardClick: () -> Unit,
) {
    val defaultShapeRadius = 6.dp
    Card(
        modifier = Modifier
            .fillMaxWidth(0.93f)
            .height(70.dp)
            .clickable {
                onCategoryCardClick
            },
        shape = RoundedCornerShape(
            defaultShapeRadius
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(category.colorId)
        ),

        ) {
        Box(
            modifier = Modifier.fillMaxSize()
        )
        {
            Image(
                painter = painterResource(id = category.iconId),
                contentDescription = "",
                Modifier
                    .padding(3.dp)
            )
            if (!category.inProgress) {
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 7.dp)
                        .align(Alignment.CenterEnd),
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "play",
                )
            } else {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 15.dp),
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription = "play",
                )
            }
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                if (category.subtitleId == null) {
                    Text(
                        fontSize = 28.sp,
                        color = Color.White,
                        text = stringResource(id = category.titleId),
                    )
                } else {
                    Row {
                        Text(
                            fontSize = 32.sp,
                            color = Color.White,
                            text = stringResource(R.string.top),
                            modifier = Modifier.padding(end = 15.dp)
                        )

                        Text(
                            fontSize = 32.sp,
                            color = Color.White,
                            text = stringResource(R.string._3000),
                            fontWeight = FontWeight.W300,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                    }

                    Text(
                        modifier = Modifier.padding(bottom = 7.dp),
                        fontSize = 14.sp,
                        color = Color.White,
                        text = stringResource(id = category.subtitleId),
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryGroup(
    modifier: Modifier = Modifier,
    onCategoryCardClick: () -> Unit,
) {
    val forBeginners = Category.ForBeginners
    val forIntermediate = Category.ForIntermediate
    val forAdvanced = Category.ForAdvanced
    val myOwnList = Category.MyOwnList

    val categories = listOf(
        forBeginners,
        forIntermediate,
        forAdvanced,
        myOwnList,
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        for (category in categories) {
            CategoryCardItem(
                category = category,
                onCategoryCardClick = onCategoryCardClick,
            )

            Spacer(modifier = Modifier.height(23.dp))
        }
    }

}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onSettingsButtonClick: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(110.dp),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = { onSettingsButtonClick },
            Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .size(30.dp)
        ) {
            Icon(
                Icons.Outlined.Settings,
                contentDescription = "",
                Modifier
                    .alpha(0.5f)
                    .fillMaxSize()
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .height(90.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                fontSize = 40.sp,
                text = stringResource(R.string.push_words),
                fontWeight = FontWeight.W400,
            )
        }
    }
}

@Preview
@Composable
private fun TopBarPreview(
    modifier: Modifier = Modifier,
) {
    TopBar(
        onSettingsButtonClick = {}
    )
}

@Preview
@Composable
private fun MainScreenPreview(
    modifier: Modifier = Modifier,
) {
    MainScreenContent(
        onCategoryCardClick = {},
        onSettingsButtonClick = {},
    )
}

@Preview
@Composable
private fun MainScreenPreview(

) {
    MainScreen()
}

@Preview
@Composable
private fun BottomBarPreview(
    modifier: Modifier = Modifier,
) {
    AppBottomBar()
}