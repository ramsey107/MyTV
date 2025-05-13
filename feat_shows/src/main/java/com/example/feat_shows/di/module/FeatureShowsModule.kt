package com.example.feat_shows.di.module

import com.example.data.source.remote.api.TVService
import com.example.feat_shows.data.ShowsRepository
import com.example.feat_shows.di.FeatureScope
import com.example.feat_shows.di.component.ViewModelSubcomponent
import com.example.feat_shows.domain.repository.IShowsRepository
import com.example.feat_shows.presentation.viewmodels.DaggerShowsViewModelFactory
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class FeatureShowsModule {

    @FeatureScope
    @Binds
    abstract fun bindShowsRepository(impl: ShowsRepository): IShowsRepository

    @Provides
    @Singleton
    fun provideShowsViewModel(tvService: TVService): ShowsViewModel {
        return ShowsViewModel(tvService)
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(viewModel: ViewModelSubcomponent.Factory): DaggerShowsViewModelFactory {
        return DaggerShowsViewModelFactory(viewModel)
    }
}