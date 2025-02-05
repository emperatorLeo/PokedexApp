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
import coil3.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.getImageUrl
import com.example.pokedexapp.domain.model.PokemonDto
import com.example.pokedexapp.presentation.theme.Dimen10dp
import com.example.pokedexapp.presentation.theme.Dimen50dp
import com.example.pokedexapp.presentation.theme.Dimen80dp
import com.example.pokedexapp.presentation.theme.Font12sp

@Composable
fun PokeItem(pokemonDto: PokemonDto, onItemClick: (Int) -> Unit) {
    Column(modifier = Modifier.clickable { onItemClick(pokemonDto.id) }) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(Dimen50dp), verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(Dimen10dp)
                    .size(Dimen80dp),
                model = getImageUrl(pokemonDto.id),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )
            Text(pokemonDto.name, fontSize = Font12sp, style = TextStyle(fontStyle = FontStyle.Italic))
        }
        HorizontalDivider()
    }
}