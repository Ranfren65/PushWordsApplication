package com.example.learnenglishapp.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,

    ) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavItem(
            iconId = R.drawable.book,
            titleId = R.string.dictionary,
            hasBadge = false,
        ),
        BottomNavItem(
            iconId = R.drawable.notification,
            titleId = R.string.repeat,
            hasBadge = true,
            badgeCount = 150,
            badgeColor = R.color.yellow_250,
        ),
        BottomNavItem(
            iconId = R.drawable.tick,
            titleId = R.string.learned,
            hasBadge = true,
            badgeCount = 813,
            badgeColor = R.color.green_150,
        ),
    )
    NavigationBar(
        containerColor = Color.Transparent,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    //navigation using direction
                    TODO()
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color.Black,
                    selectedIconColor = Color.Black,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = MaterialTheme.colorScheme.background
                ),
                label = {
                    Text(
                        text = stringResource(id = item.titleId),
                        fontSize = 14.sp
                    )
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge(
                                    containerColor = colorResource(id = item.badgeColor)
                                ) {
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = item.iconId),
                            contentDescription = stringResource(id = item.titleId)
                        )
                    }
                }
            )
        }
    }

}