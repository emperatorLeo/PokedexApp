package com.example.pokedexapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.getImageUrl
import com.example.pokedexapp.presentation.component.MovementItem
import com.example.pokedexapp.presentation.viewmodel.PokeSharedViewModel

@Composable
fun DetailScreen(viewModel: PokeSharedViewModel, navController: NavController, pokemonId: Int) {
    val pokemon = viewModel.getSelectedPokemon(pokemonId)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { Icon(
            modifier = Modifier.padding(top = 20.dp, start = 10.dp).clickable {
                navController.popBackStack()
            }.size(30.dp),
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            tint = Color.Magenta,
            contentDescription = ""
        ) }

        item { ColumnHeader(pokemon.name, pokemonId) }

        item {
            ColumnBody(
                typeList = pokemon.type,
                experience = pokemon.baseExperience,
                height = pokemon.height
            )
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                text = "Algunos de sus movientos son: ",
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

        items(pokemon.movements) {
            MovementItem(it)
        }
    }
}

@Composable
private fun ColumnHeader(pokemonName: String, id: Int) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = pokemonName,
            style = TextStyle(fontSize = 20.sp, color = Color.Magenta, fontWeight = FontWeight.Bold)
        )

        AsyncImage(
            modifier = Modifier
                .size(200.dp),
            model = getImageUrl(id),
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )
    }
}

@Composable
private fun ColumnBody(typeList: List<String>, experience: Int, height: Int) {
    val tipo = StringBuilder("Tipo: ")
    for (type in typeList) {
        tipo.append("$type, ")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = tipo.toString(),
            style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Medium)
        )

        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Experiencia: $experience",
            style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Medium)
        )

        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Altura promedio: ${(height * 10)} cm",
            style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Medium)
        )
    }
}