package com.composedemo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.composedemo.AppDestination
import com.composedemo.R
import com.composedemo.model.CardData
import com.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun ImageDetails(
    cardData: CardData,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Card(modifier = modifier
            .padding(15.dp),
            onClick = {
                onClicked(AppDestination.Profile.name)
            }) {
            Column {
                Image(
                    modifier = Modifier.size(180.dp, 180.dp),
                    painter = painterResource(cardData.imageResourceId),
                    contentDescription = null
                )
                Text(
                    cardData.name,
                    letterSpacing = TextUnit(.5f, TextUnitType.Sp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        ImageDetails(CardData("fd", R.drawable.img_1),
            onClicked = {})
    }
}
