package com.example.learnenglishapp.data.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.learnenglishapp.R

enum class Category(
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int,
    @StringRes val subtitleId: Int? = null,
    @ColorRes val colorId: Int,
    var inProgress: Boolean = false,
){
    ForBeginners(
        iconId = R.drawable.beginner,
        titleId = R.string.top_3000,
        subtitleId = R.string.for_beginners,
        colorId = R.color.green_200,
    ),
    ForIntermediate(
        iconId = R.drawable.middle,
        titleId = R.string.top_3000,
        subtitleId = R.string.middle_level,
        colorId = R.color.blue_200,
        inProgress = true,
    ),
    ForAdvanced(
        iconId = R.drawable.advanced,
        titleId = R.string.top_3000,
        subtitleId = R.string.advance_level,
        colorId = R.color.yellow_200,
    ),
    MyOwnList(
        iconId = R.drawable.books,
        titleId = R.string.your_own_list,
        colorId = R.color.gray_200,
    )
}
