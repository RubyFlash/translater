package com.example.translator.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.translator.presentation.components.BottomAppBar
import com.example.translator.presentation.components.TopAppBar

@Composable
fun FavoritesScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Favorites",
                modifier = Modifier,
            )
        },
        bottomBar = {
            BottomAppBar(navController = navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Favorites Screen", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    val navController = rememberNavController()
    FavoritesScreen(
    navController = navController
    )
}