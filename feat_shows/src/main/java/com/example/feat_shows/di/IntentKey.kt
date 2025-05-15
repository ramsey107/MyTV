package com.example.feat_shows.di

import com.example.feat_shows.intent.HomeScreenIntent
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class IntentKey(val value: KClass<out HomeScreenIntent>)
