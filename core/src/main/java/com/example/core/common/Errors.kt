package com.example.core.common

import kotlin.Error

sealed class Errors {
    object Unauthorized : Error()
    object ServerError : Error()
    object UnknownHost : Error()
}