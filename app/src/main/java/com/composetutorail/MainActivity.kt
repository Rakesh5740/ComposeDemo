package com.composetutorail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.composetutorail.data.DataSource
import com.composetutorail.model.CardData
import com.composetutorail.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DataList()
                }
            }
        }
    }
}

@Composable
fun DataList() {
    MyCard(cardItems = DataSource().getData())
}

@Composable
fun MyCard(
    cardItems: List<CardData>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier) {

        items(cardItems) { data ->
            SetData(
                data,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun SetData(cardData: CardData, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                modifier = Modifier.size(100.dp, 100.dp),
                alignment = Alignment.Center,
                painter = painterResource(cardData.imageResourceId),
                contentDescription = null
            )
            Text(
                cardData.name, color = Color.Black,
                letterSpacing = TextUnit(.5f, TextUnitType.Sp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        DataList()
    }
}