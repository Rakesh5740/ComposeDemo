package com.composetutorail.data

import com.composetutorail.model.CardData
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
}