package com.example.pokedexapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedexapp.R
import com.example.pokedexapp.presentation.theme.Dimen10dp
import com.example.pokedexapp.presentation.theme.Dimen250
import com.example.pokedexapp.presentation.theme.Font20sp

@Composable
@Preview(showBackground = true)
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(Dimen10dp)
                    .size(Dimen250)
            )
            Text(
                modifier = Modifier.padding(Dimen10dp),
                text = stringResource(R.string.please_wait),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = Font20sp, color = Color.Magenta, fontWeight = FontWeight.Bold)
            )
        }
    }
}