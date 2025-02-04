package com.example.pokedexapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.presentation.screen.DetailScreen
import com.example.pokedexapp.presentation.screen.MainScreen
import com.example.pokedexapp.presentation.viewmodel.PokeSharedViewModel

@Composable
fun AppNavigation(
    viewModel: PokeSharedViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.MAIN_SCREEN
    ) {

        composable(AppRoutes.MAIN_SCREEN) {
            MainScreen(viewModel = viewModel, navController)
        }

        composable(AppRoutes.DETAIL_SCREEN) {
            DetailScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}
