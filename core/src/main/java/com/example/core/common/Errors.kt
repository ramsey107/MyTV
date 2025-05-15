package com.example.core.common

sealed class Errors {
    data object Unauthorized : Errors()
    data object ServerError : Errors()
    data object UnknownHost : Errors()
}