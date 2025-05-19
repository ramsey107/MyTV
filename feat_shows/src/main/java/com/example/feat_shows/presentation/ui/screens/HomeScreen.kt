package com.example.feat_shows.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.core.common.Url
import com.example.core.nav.Routes
import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState
import com.example.common.components.CircularProgress
import com.example.common.components.ErrorBox
import com.example.common.components.ShowImage
import com.example.common.components.TopBar
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel

@Composable
fun HomeScreen(
    viewModel: ShowsViewModel,
    navController: NavController
) {
    val uiState = viewModel.state.collectAsState()
    val pageCount = viewModel.pageCount.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(UiIntent.FetchPopularShows(1))
    }

    when (val shows = uiState.value) {
        is UiState.ShowsListSuccess -> {
            Scaffold(
                topBar = { TopBar("Shows") }
            ) { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    items(shows.result) { show ->
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Routes.Details.createRoute(show.id))
                                }
                                .fillMaxWidth()
                                .padding(start = 8.dp, end = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ShowImage("${Url.IMAGE_BASE_URL}${show.poster}",                            modifier = Modifier
                                    .width(58.dp)
                                    .height(58.dp)
                                    .padding(start = 16.dp))
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp, end = 16.dp),
                                    text = show.name,
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = Color.Black,
                                    )
                                )
                            }
                        }
                    }

                    item {
                        LaunchedEffect(Unit) {
                            viewModel.loadMoreShows(pageCount.value)
                        }
                    }
                }
            }
        }

        is UiState.Error -> {
            ErrorBox("No Shows available!")
        }
        UiState.Loading -> {
            CircularProgress()
        }
        else -> {

        }
    }
}