package com.example.feat_shows.di.module

import androidx.lifecycle.ViewModel
import com.example.feat_shows.di.ViewModelKey
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ShowsViewModel::class)
    abstract fun bindShowsViewModel(viewModel: ShowsViewModel): ViewModel
} 