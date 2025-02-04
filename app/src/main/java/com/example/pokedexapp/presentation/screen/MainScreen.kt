package com.example.pokedexapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.getImageUrl
import com.example.pokedexapp.domain.model.PokemonDto
import com.example.pokedexapp.presentation.UIState
import com.example.pokedexapp.presentation.viewmodel.PokeSharedViewModel

@Composable
fun MainScreen(viewModel: PokeSharedViewModel, navaController: NavController) {
    viewModel.getAllDBPokemons()
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { _ ->
        when (state.value) {
            is UIState.Error -> {}
            UIState.Idle -> {}
            UIState.Loading -> {
                LoadingComponent()
            }

            is UIState.Success -> {
                LazyColumn(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item { SearchBarComponent() }
                    val list = state.value as UIState.Success
                    items(list.data) {
                        PokeItemComponent(it)
                    }
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SearchBarComponent() {
    Row(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Icon(
            modifier = Modifier.padding(10.dp),
            imageVector = Icons.Rounded.Search,
            tint = Color.Magenta,
            contentDescription = ""
        )
        TextField(value = "busca tu pokemon", onValueChange = { text -> })
    }
}

@Composable
private fun PokeItemComponent(pokemonDto: PokemonDto) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(10.dp)
                    .size(80.dp),
                model = getImageUrl(pokemonDto.id),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )
            Text(pokemonDto.name, fontSize = 12.sp, style = TextStyle(fontStyle = FontStyle.Italic))
        }
        HorizontalDivider()
    }
}

@Composable
@Preview(showBackground = true)
private fun LoadingComponent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(250.dp)
            )

            Text("Espera, estamos atrapando todos los pokemones para ti")
        }
    }
}