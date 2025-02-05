package com.example.pokedexapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    text: String,
    search: (String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Icon(
            modifier = Modifier.padding(10.dp),
            imageVector = Icons.Rounded.Search,
            tint = Color.Magenta,
            contentDescription = ""
        )
        TextField(enabled = enabled, value = text, onValueChange = { input ->
            search(input)
        }, label = {
            Text(
                "Busca tu Pokemon",
                fontSize = 12.sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
        })
    }
}
