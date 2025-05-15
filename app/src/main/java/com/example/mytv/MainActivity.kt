package com.example.mytv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.feat_shows.presentation.ui.screens.HomeScreen
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import com.example.mytv.ui.theme.MyTvTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val showsViewModel: ShowsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTvTheme {
                HomeScreen(showsViewModel)
            }
        }
    }
}
