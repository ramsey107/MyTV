package com.example.data.di.component

import com.example.data.di.module.NetworkModule
import com.example.data.source.remote.api.TVService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface DataComponent {
    fun getTvService(): TVService
}