package com.example.feat_shows.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feat_shows.presentation.mvi.ShowsEffect
import com.example.feat_shows.presentation.mvi.ShowsIntent
import com.example.feat_shows.presentation.mvi.ShowsState
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    viewModel: ShowsViewModel,
    onShowSelected: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.handleIntent(ShowsIntent.LoadShows)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is ShowsEffect.NavigateToShowDetails -> onShowSelected(effect.showId)
                is ShowsEffect.ShowError -> {
                    // Handle error (e.g., show snackbar)
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.error != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = state.error ?: "Unknown error")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.handleIntent(ShowsIntent.Retry) }) {
                        Text("Retry")
                    }
                }
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(state.shows) { show ->
                        ShowItem(
                            show = show,
                            onClick = { viewModel.handleIntent(ShowsIntent.ShowSelected(show.id)) }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ShowItem(
    show: Show,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = show.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = show.overview,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}