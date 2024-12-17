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
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composedemo.AppDestination
import com.composedemo.ComposeAppBar
import com.composedemo.MainViewModel
import com.composedemo.model.CardData


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val productList by viewModel.productsList.observeAsState()
    val selectedCard by viewModel.selectedCard.observeAsState()
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
            startDestination = AppDestination.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = AppDestination.Start.name) {
                productList?.let { it1 ->
                    HomeScreen(it1.productList,
                        onClicked = { screen, cardData ->
                            it1.productList[0]?.let { it2 ->
                                viewModel.updateSelectedCard(
                                    cardData = cardData
                                )
                            }
                            navController.navigate(screen)
                        })
                }
            }

            composable(route = AppDestination.Settings.name) {
                selectedCard?.let { it1 ->
                    ImageDetails(it1,
                        onClicked = {
                            navController.navigate(it)
                        })
                }
            }

            composable(route = AppDestination.Profile.name) {
                ComposeProfile()
            }
        }
    }
}