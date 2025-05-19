package com.example.feat_show_details.di

import com.example.data.source.remote.api.TVService
import com.example.data.source.repository.IShowsDetailsRepository
import com.example.feat_show_details.repository.ShowDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FeatureModule {

    @Provides
    fun providesShowDetailsRepository(service: TVService): IShowsDetailsRepository {
        return ShowDetailsRepository(service)
    }

}