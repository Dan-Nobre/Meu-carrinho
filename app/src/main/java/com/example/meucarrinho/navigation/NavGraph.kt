package com.example.meucarrinho.navigation

import android.util.Log.i
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meucarrinho.ui.screens.AddItemScreen
import com.example.meucarrinho.ui.screens.HomeScreen
import com.example.meucarrinho.viewModel.ShoppingViewModel

sealed class Screen(val route: String) {
    object Home    : Screen("home")
    object AddItem : Screen("add_item")
}

@Composable
fun MeuCarrinhoNavGraph() {
    val navController = rememberNavController()

    val viewModel: ShoppingViewModel = viewModel()

    NavHost(
        navController    = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onAddClick = {
                    navController.navigate(Screen.AddItem.route)
                },
                items = viewModel.items.collectAsState().value,
                onToggleItem = { id -> viewModel.toggleItem(id) },
            )
        }
        composable(Screen.AddItem.route) {
            AddItemScreen(
                onBack = {
                    navController.popBackStack()
                },
                onConfirm = {
                    name, category, quantity -> viewModel.addItem(name, category, quantity)
                    navController.popBackStack()
                },
            )
        }
    }
}

