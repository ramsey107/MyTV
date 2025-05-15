package com.example.feat_shows.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.feat_shows.handler.FetchPopularShowsHandler
import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import com.example.feat_shows.state.UiState
import org.w3c.dom.Text

@Composable
fun HomeScreen(
    viewModel: ShowsViewModel,
) {
    val uiState = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeScreenIntent.FetchPopularShows)
    }
    Box {
        when(val result = uiState.value){
            is UiState.Error -> {

            }
            UiState.Loading -> {

            }
            UiState.Nothing -> {

            }
            is UiState.Success -> {

            }
        }
    }
}