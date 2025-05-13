package com.example.feat_shows.di.component

import com.example.feat_shows.di.module.ViewModelModule
import com.example.feat_shows.presentation.viewmodels.ShowsViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ViewModelSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ViewModelSubcomponent
    }

    fun getShowsViewModel(): ShowsViewModel
}