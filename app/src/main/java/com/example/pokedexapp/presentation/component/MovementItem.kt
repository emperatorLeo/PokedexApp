package com.example.pokedexapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.Movement
import com.example.pokedexapp.presentation.theme.Dimen10dp
import com.example.pokedexapp.presentation.theme.Dimen50dp
import com.example.pokedexapp.presentation.theme.Dimen5dp
import com.example.pokedexapp.presentation.theme.Font12sp

@Composable
fun MovementItem(movement: Movement) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(Dimen50dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(end = Dimen5dp),
                text = movement.movementName,
                fontSize = Font12sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
            VerticalDivider(modifier = Modifier.padding(end = Dimen10dp))
            Text(
                stringResource(R.string.learned_at, movement.movementLearnAt),
                fontSize = Font12sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
        }
        HorizontalDivider()
    }
}