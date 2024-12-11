package com.composedemo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composedemo.ComposeScreen
import com.composedemo.data.DataSource
import com.composedemo.model.CardData
import com.composedemo.ui.theme.ComposeDemoTheme


@Composable
fun DataList(onClicked: (String) -> Unit) {
    MyCard(
        cardItems = DataSource.cardData,
        modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp),
        onClicked
    )
}

@Composable
fun MyCard(
    cardItems: List<CardData>,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    MyCardRow(cardItems, modifier = modifier, onClicked)
}

@Composable
fun MyCardRow(
    cardItems: List<CardData>,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    LazyRow(modifier = modifier) {
        items(cardItems) { data ->
            SetData(
                data,
                modifier = Modifier.padding(8.dp),
                onClicked
            )
        }
    }
}

@Composable
fun SetData(cardData: CardData, modifier: Modifier = Modifier, onClicked: (String) -> Unit) {
    Card(modifier = modifier,
        onClick = {
            onClicked(ComposeScreen.Profile.name)
        }) {
        Column {
            Image(
                modifier = Modifier.size(100.dp, 100.dp),
                alignment = Alignment.Center,
                painter = painterResource(cardData.imageResourceId),
                contentDescription = null
            )
            Text(
                cardData.name,
                letterSpacing = TextUnit(.5f, TextUnitType.Sp),
                style = TextStyle(
                    color = Color.Black, fontSize = 16.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        DataList(onClicked = {})
    }
}
