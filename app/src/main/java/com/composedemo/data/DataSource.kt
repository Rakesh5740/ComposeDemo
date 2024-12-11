package com.composedemo.data

import com.composedemo.R
import com.composedemo.model.CardData
import com.composedemo.model.Flower

/*
* Generates a list here
* */

object DataSource {
    val cardData = mutableListOf(
        CardData("AAAAAAAAAA", R.drawable.img_1),
        CardData("BBBBBB", R.drawable.img_2),
        CardData("CCCCCCCCC", R.drawable.img_3),
        CardData("DDDDDDDD", R.drawable.img_1),
        CardData("EEEEEEE", R.drawable.img_2),
        CardData("FFFFFFFF", R.drawable.img_3),
    )

    val flowerList = mutableListOf(
        Flower("AAAAAAA", 344, R.drawable.img_1),
        Flower("BBBBB", 234, R.drawable.img_2),
        Flower("CCCCCC", 344, R.drawable.img_3),
        Flower("DDDDDDD", 878, R.drawable.img_3),
        Flower("EEEEEE", 344, R.drawable.img_2),
        Flower("FFFFFFFF", 344, R.drawable.img_1),
    )

}