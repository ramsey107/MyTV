package com.example.mytv

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.core.nav.Routes
import com.example.feat_show_details.presentation.ui.DetailsScreen
import com.example.feat_show_details.presentation.viewmodels.DetailsViewModel
import com.example.feat_shows.presentation.ui.screens.HomeScreen
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel

@Composable
fun App() {
    val navController = rememberNavController()
    val showsViewModel: ShowsViewModel = hiltViewModel()
    
    NavHost(navController, startDestination = Routes.Home.name) {
        composable(Routes.Home.name) {
            HomeScreen(showsViewModel, navController)
        }
        composable(
            route = Routes.Details.name,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            if (id != null) {
                val detailsViewModel: DetailsViewModel = hiltViewModel()
                DetailsScreen(
                    id = id,
                    viewModel = detailsViewModel
                )
            }
        }
    }
}
