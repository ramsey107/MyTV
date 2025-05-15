package com.example.feat_shows.di

import com.example.feat_shows.dispatcher.IntentDispatcher
import com.example.feat_shows.dispatcher.IntentDispatcherImpl
import com.example.feat_shows.handler.FetchPopularShowsHandler
import com.example.feat_shows.handler.IntentHandler
import com.example.feat_shows.intent.HomeScreenIntent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
abstract class IntentHandlerModule {

    @Binds
    @IntoMap
    @IntentKey(HomeScreenIntent.FetchPopularShows::class)
    abstract fun bindsFetchPopularShows(
        handler: FetchPopularShowsHandler
    ): IntentHandler<out HomeScreenIntent>

    @Binds
    abstract fun bindIntentDispatcher(
         impl: IntentDispatcherImpl
    ): IntentDispatcher

}