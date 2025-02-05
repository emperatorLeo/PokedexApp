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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import com.example.pokedexapp.R
import com.example.pokedexapp.common.EMPTY_STRING
import com.example.pokedexapp.presentation.theme.Dimen10dp
import com.example.pokedexapp.presentation.theme.Font12sp

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
            modifier = Modifier.padding(Dimen10dp),
            imageVector = Icons.Rounded.Search,
            tint = Color.Magenta,
            contentDescription = EMPTY_STRING
        )
        TextField(enabled = enabled, value = text, onValueChange = { input ->
            search(input)
        }, label = {
            Text(
                stringResource(R.string.search_your_pokemnon),
                fontSize = Font12sp,
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
        })
    }
}
