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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.domain.model.Movement

@Composable
fun MovementItem(movement: Movement) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(end = 5.dp),
                text = movement.movementName,
                fontSize = 12.sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
            VerticalDivider(modifier = Modifier.padding(end = 10.dp))
            Text(
                "Lo aprende en el LVL: ${movement.movementLearnAt}",
                fontSize = 12.sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
        }
        HorizontalDivider()
    }
}