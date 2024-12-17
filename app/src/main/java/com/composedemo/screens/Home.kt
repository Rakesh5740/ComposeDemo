package com.composedemo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.composedemo.AppDestination
import com.composedemo.R
import com.composedemo.data.ProductData
import com.composedemo.model.CardData
import com.composedemo.ui.theme.ComposeDemoTheme


@Composable
fun HomeScreen(
    productList: List<ProductData?>,
    onClicked: (String, CardData) -> Unit
) {
    Column {
        Surface(modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp)) {
            Text(
                text = "Popular",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
        LazyRow {
            items(items = productList,
                itemContent = { item ->
                    SetData(item, onClicked)
                })
        }
        Surface(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Flowers",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        LazyRow {
            items(items = productList,
                itemContent = { flowers ->
                    SetData(flowers, onClicked)
                })
        }
        Surface(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Testing",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        LazyRow {
            items(items = productList,
                itemContent = { flowers ->
                    SetData(flowers, onClicked)
                })
        }
        Surface(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Demo App",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        LazyRow {
            items(items = productList,
                itemContent = { flowers ->
                    SetData(flowers, onClicked)
                })
        }
        Surface(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Demo",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        LazyRow {
            items(items = productList,
                itemContent = { flowers ->
                    SetData(flowers, onClicked = onClicked)
                })
        }
    }
}

@Composable
private fun SetData(
    item: ProductData?,
    onClicked: (String, CardData) -> Unit
) {
    val dummyImage = "https://picsum.photos/536/354"
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(180.dp),
        onClick = {
            item?.let {
                CardData(it.id, item.title, dummyImage)
            }?.let {
                onClicked(
                    AppDestination.Settings.name,
                    it
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = dummyImage,
                placeholder = painterResource(R.drawable.img_2),
                error = painterResource(R.drawable.img_3),
                contentDescription = null,
            )

            Row(modifier = Modifier.padding(top = 20.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item?.title ?: "",
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 14.sp
                        )
                    )
                    Text(
                        text = item?.id.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    )
                }
                IconButton(
                    onClick = { dummyImage },
                    modifier = Modifier.background(
                        color = Color.Red,
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(
                        Icons.Default.Add,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeDemoTheme {
//        HomeScreen(emptyList(), onClicked = {})
    }
}