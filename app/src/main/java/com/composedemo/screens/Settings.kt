package com.composedemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.composedemo.AppDestination
import com.composedemo.MainViewModel
import com.composedemo.R
import com.composedemo.model.CardData
import com.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun ImageDetails(
    cardData: CardData,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Card(modifier = modifier
            .padding(15.dp),
            onClick = {
                onClicked(AppDestination.Profile.name)
            }) {
            Column {
                AsyncImage(
                    modifier = Modifier.size(180.dp, 180.dp),
                    model = cardData.images,
                    placeholder = painterResource(R.drawable.img_2),
                    error = painterResource(R.drawable.img_3),
                    contentDescription = null,
                )

                Text(
                    cardData.title,
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
//        ImageDetails(CardData("fd", R.drawable.img_1),
//            onClicked = {})
    }
}
