package com.example.common.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ShowImage(imagePath: String,modifier: Modifier) {
    AsyncImage(
        modifier = modifier,
        model = imagePath,
        contentDescription = "Show Poster",
        contentScale = ContentScale.Crop
    )
}
