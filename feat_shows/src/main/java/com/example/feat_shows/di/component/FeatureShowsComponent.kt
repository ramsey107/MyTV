package com.example.feat_shows.di.component

import com.example.data.di.component.DataComponent
import com.example.feat_shows.di.module.FeatureShowsModule
import com.example.feat_shows.di.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [DataComponent::class],
    modules = [FeatureShowsModule::class]
)
interface FeatureShowsComponent {
    fun getShowsViewModel(): ShowsViewModel
    fun getViewModelFactory(): DaggerShowsViewModelFactory
} 