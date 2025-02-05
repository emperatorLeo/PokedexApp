package com.example.pokedexapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexapp.presentation.navigation.AppRoutes.DETAIL_SCREEN
import com.example.pokedexapp.presentation.navigation.AppRoutes.MAIN_SCREEN
import com.example.pokedexapp.presentation.navigation.AppRoutes.POKE_ID
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
        startDestination = MAIN_SCREEN
    ) {

        composable(route = MAIN_SCREEN) {
            MainScreen(viewModel = viewModel, navController)
        }

        composable(route = DETAIL_SCREEN,
            arguments = listOf(
                navArgument(POKE_ID) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val pokeId = navBackStackEntry.arguments?.getInt(POKE_ID) ?: 0
            DetailScreen(
                viewModel = viewModel,
                navController = navController,
                pokeId
            )
        }
    }
}
