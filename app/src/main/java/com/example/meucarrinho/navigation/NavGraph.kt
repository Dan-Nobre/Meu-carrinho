package com.example.meucarrinho.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meucarrinho.ui.screens.AddItemScreen
import com.example.meucarrinho.ui.screens.HomeScreen

sealed class Screen(val route: String) {
    object Home    : Screen("home")
    object AddItem : Screen("add_item")
}

@Composable
fun MeuCarrinhoNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController    = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onAddClick = {
                    navController.navigate(Screen.AddItem.route)
                }
            )
        }
        composable(Screen.AddItem.route) {
            AddItemScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

