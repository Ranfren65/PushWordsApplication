package com.example.learnenglishapp.data.model

import android.graphics.Path.Direction
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int,
    val hasBadge: Boolean,
    val badgeCount: Int?=null,
    val direction:Direction?=null
)
