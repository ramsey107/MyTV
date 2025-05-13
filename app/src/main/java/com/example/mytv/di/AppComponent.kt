package com.example.mytv.di

import com.example.mytv.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}