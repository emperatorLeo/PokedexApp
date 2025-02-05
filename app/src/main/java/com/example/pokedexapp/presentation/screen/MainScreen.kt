package com.example.pokedexapp.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.pokedexapp.presentation.component.PokeItem
import com.example.pokedexapp.presentation.component.SearchBarComponent
import com.example.pokedexapp.presentation.navigation.AppRoutes
import com.example.pokedexapp.presentation.states.UIState
import com.example.pokedexapp.presentation.viewmodel.PokeSharedViewModel

@Composable
fun MainScreen(viewModel: PokeSharedViewModel, navController: NavController) {
    viewModel.checkConnection()
    viewModel.getAllDBPokemons()
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    var text by remember { mutableStateOf("") }
    var searchBarEnabled by remember { mutableStateOf(false) }

    LazyColumn(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            SearchBarComponent(
                modifier = Modifier.padding(top = 50.dp),
                enabled = searchBarEnabled,
                text
            ) { input ->
                text = input
                if (input.isEmpty()) {
                    viewModel.getAllDBPokemons()
                } else {
                    viewModel.searchPokemon(input)
                }
            }
        }

        when (state.value) {
            is UIState.Idle -> {}
            is UIState.Loading -> {
                searchBarEnabled = false
                item { LoadingScreen() }
            }

            is UIState.Success -> {
                searchBarEnabled = true
                if (state.value is UIState.Success) {
                    items((state.value as UIState.Success).data) {
                        PokeItem(it) { pokeId ->
                            val route = AppRoutes.DETAIL_SCREEN.replace(
                                "{${AppRoutes.POKE_ID}}",
                                pokeId.toString()
                            )
                            navController.navigate(route)
                        }
                    }
                }
            }

            is UIState.Error.NoInternetConnection -> item {
                searchBarEnabled = false
                NoInternetConnectionScreen()
            }

            is UIState.Error.UnknownPokemon -> item {
                searchBarEnabled = true
                UnknownPokemonScreen()
            }

            is UIState.Error.Exception -> item {
                searchBarEnabled = false
                ExceptionScreen()
            }
        }
    }
}