package com.composetutorail.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composetutorail.ComposeAppBar
import com.composetutorail.ComposeScreen
import com.composetutorail.MainViewModel
import com.composetutorial.R


@Composable
fun MainScreen(
    screenName: String,
    viewModel: ViewModel = MainViewModel(),
    navController: NavHostController = rememberNavController()
) {
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
                HomeScreen(onClicked = {
                    navController.navigate(ComposeScreen.Settings.name)
                })
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