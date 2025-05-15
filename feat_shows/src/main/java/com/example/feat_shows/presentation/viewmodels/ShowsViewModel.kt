package com.example.feat_shows.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.Errors
import com.example.feat_shows.dispatcher.IntentDispatcher
import com.example.feat_shows.intent.HomeScreenIntent
import com.example.feat_shows.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val intentDispatcher: IntentDispatcher,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Nothing)
//    val homeScreenState: StateFlow<UiState> = _homeScreenState
    val state = _state.asStateFlow()

    //Optimize using reducer
    fun onIntent(intent: HomeScreenIntent) {
        viewModelScope.launch {
            when (val result = intentDispatcher.dispatch(intent)) {
                UiState.Loading -> {
                    _state.value = UiState.Loading
                }
                is UiState.Success -> {
                    _state.value = UiState.Success(result.shows)
                }
                is UiState.Error -> {
                    _state.value = UiState.Error(Errors.ServerError)
                }
                is UiState.Nothing -> {
                    //No need to use
                }
            }
        }
    }

}