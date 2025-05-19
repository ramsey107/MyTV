package com.example.core.shared.intent

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class IntentKey(val value: KClass<out UiIntent>)
