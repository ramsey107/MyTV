package com.example.mytv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.feat_shows.presentation.ui.screens.HomeScreen
import com.example.feat_shows.presentation.viewmodels.DaggerShowsViewModelFactory
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import com.example.mytv.ui.theme.MyTvTheme

class MainActivity : ComponentActivity() {

//    private val appComponent: AppComponent by lazy {
//        DaggerAppComponent.create() // or your setup
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val showsViewModel = DaggerShowsViewModelFactory().create(ShowsViewModel::class.java)
        enableEdgeToEdge()
        setContent {
            MyTvTheme {
                HomeScreen()
            }
        }
    }
}
