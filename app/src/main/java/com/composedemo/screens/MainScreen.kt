package com.composedemo.screens

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composedemo.AppDestination
import com.composedemo.ComposeAppBar
import com.composedemo.MainViewModel
import com.composedemo.R
import com.composedemo.data.ProductList
import com.composedemo.model.CardData
import com.composedemo.network.ApiState


@Composable
fun MainScreen(
    screenName: String,
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val productList by viewModel.productsList.observeAsState()
    val context = LocalContext.current


    /* Get current back stack entry  */
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppDestination.valueOf(
        backStackEntry?.destination?.route ?: AppDestination.Start.name
    )

    Scaffold(
        topBar = {
            ComposeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = screenName,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = AppDestination.Start.name) {
                // Display data

                when (productList) {
                    is ApiState.Loading -> {
                        // Show loading indicator
                    }

                    is ApiState.Success -> {
                        // Display data
                        val data = (productList as ApiState.Success<ProductList>).data
                        HomeScreen(data.productList, onClicked = {
                            navController.navigate(AppDestination.Settings.name)
                        })
                    }

                    is ApiState.Error -> {
                        Toast.makeText(
                            context.applicationContext,
                            "Something went wrong", Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }

            composable(route = AppDestination.Settings.name) {
                ImageDetails(CardData("HH", R.drawable.img_1), onClicked = {
                    navController.navigate(AppDestination.Profile.name)
                })
            }

            composable(route = AppDestination.Profile.name) {
                ComposeProfile()
            }
        }
    }
}