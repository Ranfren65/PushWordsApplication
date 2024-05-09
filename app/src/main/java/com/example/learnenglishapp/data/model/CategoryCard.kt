package com.example.learnenglishapp.data.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoryCard(
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int,
    @StringRes val subtitleId: Int? = null,
    @ColorRes val colorId: Int,
    val inProgress: Boolean = false,
)
