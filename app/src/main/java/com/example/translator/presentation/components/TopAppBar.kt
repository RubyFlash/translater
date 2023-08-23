package com.example.translator.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String, modifier: Modifier) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = modifier,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = { Unit }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Top app bar menu icon")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(
        title = "Home",
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp),
    )
}