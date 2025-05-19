package com.example.feat_show_details.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.common.components.CircularProgress
import com.example.common.components.ErrorBox
import com.example.common.components.ShowImage
import com.example.common.components.UnknownBox
import com.example.core.common.Url
import com.example.core.shared.state.UiState
import com.example.feat_show_details.presentation.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel
) {
    val uiState = viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.getShowDetails(id)
    }

    Surface(modifier = modifier.fillMaxSize()) {
        when (val state = uiState.value) {
            is UiState.ShowSuccess -> {
                val show = state.result
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    ShowImage("${Url.IMAGE_BASE_URL}${show.poster}",                        modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = show.name,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = show.genres.joinToString(", "),
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${show.numberOfSeasons} Seasons",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = show.country,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Popularity: ${String.format("%.1f", show.popularity)}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Overview",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = show.overview,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            is UiState.Loading -> {
                CircularProgress()
            }
            is UiState.Error -> {
                ErrorBox("Error loading show details")
            }
            else -> {
                UnknownBox()
            }
        }
    }
}