package com.composedemo.model

import androidx.annotation.DrawableRes

data class Flower(
    val name: String,
    var price: Int,
    @DrawableRes val image: Int
)
