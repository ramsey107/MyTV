package com.example.feat_shows.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feat_shows.di.component.ViewModelSubcomponent
import javax.inject.Inject

class DaggerShowsViewModelFactory @Inject constructor(
    private val subcomponentFactory: ViewModelSubcomponent.Factory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ShowsViewModel::class.java -> subcomponentFactory.create().getShowsViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        }
    }
}