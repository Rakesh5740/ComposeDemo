package com.composetutorail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
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
import com.composetutorail.data.DataSource
import com.composetutorail.model.Flower
import com.composetutorail.ui.theme.ComposeDemoTheme

class FlowerActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            titleContentColor = Color.White,
                        ),
                        title = {
                            Text(text = "ComposeDemo")
                        },
//                        navigationIcon = {
//                            IconButton(onClick = { }) {
//                                Icon(Icons.Filled.Menu, "")
//                            }
//                        },
                    )
                }, content = {
                    Surface(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainScreen()
                    }
                })
        }
    }

    @Composable
    private fun MainScreen() {
        Column {
            Surface(modifier = Modifier.padding(10.dp, 80.dp, 10.dp, 10.dp)) {
                Text(
                    text = "Popular Flowers",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            LazyRow {
                items(items = DataSource().getFlowerDetails(),
                    itemContent = { flowers ->
                        FlowerCard(flowers)
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
                items(items = DataSource().getFlowerDetails(),
                    itemContent = { flowers ->
                        FlowerCard(flowers)
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
                items(items = DataSource().getFlowerDetails(),
                    itemContent = { flowers ->
                        FlowerCard(flowers)
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
                items(items = DataSource().getFlowerDetails(),
                    itemContent = { flowers ->
                        FlowerCard(flowers)
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
                items(items = DataSource().getFlowerDetails(),
                    itemContent = { flowers ->
                        FlowerCard(flowers)
                    })
            }
        }
    }

    @Composable
    private fun FlowerCard(flower: Flower) {
        Card(
            shape = RoundedCornerShape(14.dp),
//            backgroundColor = Color.White,
            modifier = Modifier
                .padding(10.dp)
                .width(180.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = flower.image),
                    contentDescription = null,
                    modifier = Modifier.size(160.dp)
                )
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = flower.name,
                            style = TextStyle(
                                color = Color.DarkGray,
                                fontSize = 14.sp
                            )
                        )
                        Text(
                            text = flower.price.toString(),
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }
                    IconButton(
                        onClick = { },
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
    fun FlowersPreview() {
        ComposeDemoTheme {
            MainScreen()
        }
    }
}