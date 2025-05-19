package com.example.feat_shows.di

import com.example.core.dispatcher.IntentDispatcher
import com.example.core.handler.IntentHandler
import com.example.core.shared.intent.IntentKey
import com.example.core.shared.intent.UiIntent
import com.example.feat_shows.dispatcher.IntentDispatcherImpl
import com.example.feat_shows.handler.FetchPopularShowsHandler
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Language

@Module
@InstallIn(ViewModelComponent::class)
abstract class IntentHandlerModule {

    @Binds
    @IntoMap
    @IntentKey(UiIntent.FetchPopularShows::class)
    abstract fun bindsFetchPopularShows(
        handler: FetchPopularShowsHandler
    ): IntentHandler<out UiIntent>

    @Binds
    abstract fun bindIntentDispatcher(
         impl: IntentDispatcherImpl
    ): IntentDispatcher

    companion object {
        @Provides
        fun providePageNumber(): Int = 1

        @Provides
        @Language
        fun provideLanguage(): String = "en-US"
    }
}