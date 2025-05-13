package com.example.core.utils

interface Mapper<I,O> {
    fun map(i: I): O
}