package com.example.pokedexapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.getImageUrl
import com.example.pokedexapp.domain.model.PokemonDto

@Composable
fun PokeItem(pokemonDto: PokemonDto, onItemClick: (Int) -> Unit) {
    Column(modifier = Modifier.clickable { onItemClick(pokemonDto.id) }) {
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