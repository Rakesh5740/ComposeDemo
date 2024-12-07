package com.composetutorail.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Flower(
    val name: String,
    var price: Int,
    @DrawableRes val image: Int
)
