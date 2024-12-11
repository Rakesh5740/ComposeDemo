package com.composedemo.model

import androidx.annotation.DrawableRes

data class CardData(
    var name: String,
    @DrawableRes val imageResourceId: Int

)
