package com.composedemo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composedemo.ComposeAppBar
import com.composedemo.ComposeScreen
import com.composedemo.MainViewModel
import timber.log.Timber


@Composable
fun MainScreen(
    screenName: String,
    navController: NavHostController = rememberNavController()
) {
    val productsViewModel: MainViewModel = viewModel()
    val productList by productsViewModel.productsList.observeAsState()
    Timber.e("@@@@@@@@@@: ${productList.toString()}")


//    productsViewModel.productsList.observe(this, Observer { state ->
//        when (state) {
//            is ApiState.Loading -> {
//                // Show loading indicator
//            }
//
//            is ApiState.Success -> {
//                // Display data
//                val data = state.data
//            }
//
//            is ApiState.Error -> {
//                // Show error message
//                val error = state.failureType
//            }
//        }
//    })

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = ComposeScreen.valueOf(
        backStackEntry?.destination?.route ?: ComposeScreen.Start.name
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
            composable(route = ComposeScreen.Start.name) {
//                productList?.let { it1 ->
                HomeScreen(onClicked = {
                    navController.navigate(ComposeScreen.Settings.name)
                })
//                }
            }

            composable(route = ComposeScreen.Settings.name) {
                DataList(onClicked = {
                    navController.navigate(ComposeScreen.Profile.name)
                })
            }

            composable(route = ComposeScreen.Profile.name) {
                ComposeProfile()
            }

        }
    }
}