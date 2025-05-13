package com.example.core.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<I : MviIntent, S : MviState, E : MviEffect> : ViewModel() {

    private val initialState: S by lazy { createInitialState() }
    abstract fun createInitialState(): S

    private val _viewState = MutableStateFlow(initialState)
    val viewState: StateFlow<S> = _viewState.asStateFlow()

    private val _effect = Channel<E>()
    val effect = _effect.receiveAsFlow()

    abstract fun handleIntent(intent: I)

    protected fun setState(reduce: S.() -> S) {
        val newState = viewState.value.reduce()
        _viewState.value = newState
    }

    protected fun setEffect(builder: () -> E) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
} 