package com.composetutorail.data

import com.composetutorail.model.CardData
import com.composetutorail.model.Flower
import com.composetutorial.R

/*
* Generates a list here
* */

class DataSource {
    fun getData(): List<CardData> {
        return mutableListOf(
            CardData("AAAAAAAAAA", R.drawable.ic_launcher_background),
            CardData("BBBBBB", R.drawable.ic_launcher_background),
            CardData("CCCCCCCCC", R.drawable.ic_launcher_background),
            CardData("DDDDDDDD", R.drawable.ic_launcher_background),
            CardData("EEEEEEE", R.drawable.ic_launcher_background),
            CardData("FFFFFFFF", R.drawable.ic_launcher_background),
            CardData("GGGGGGGG", R.drawable.ic_launcher_background),
            CardData("HHHH", R.drawable.ic_launcher_background),
            CardData("IIII", R.drawable.ic_launcher_background),
            CardData("JJJJJJ", R.drawable.ic_launcher_background),
            CardData("KKKKKKKK", R.drawable.ic_launcher_background),
            CardData("LLLLLL", R.drawable.ic_launcher_background),
        )
    }

    fun getFlowerDetails(): List<Flower> {
        return mutableListOf(
            Flower("aaa", 344, R.drawable.img_1),
            Flower("fff", 234, R.drawable.img_2),
            Flower("fff", 344, R.drawable.img_3),
            Flower("dsds", 878, R.drawable.img_3),
            Flower("vff", 344, R.drawable.img_2),
            Flower("aaa", 344, R.drawable.img_1),
            Flower("aaa", 344, R.drawable.img_1),
            Flower("aaa", 344, R.drawable.img_2),
            Flower("aaa", 344, R.drawable.img_3),
            Flower("bggb", 354, R.drawable.img_1)
        )
    }
}