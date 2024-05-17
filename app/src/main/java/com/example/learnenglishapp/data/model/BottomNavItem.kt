package com.example.learnenglishapp.data.model

import android.graphics.Path.Direction
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.learnenglishapp.R

data class BottomNavItem(
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int,
    val hasBadge: Boolean,
    val badgeCount: Int?=null,
    val direction:Direction?=null,
    @ColorRes val badgeColor:Int= R.color.yellow_200
)
