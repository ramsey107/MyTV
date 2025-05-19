package com.example.feat_shows.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dispatcher.IntentDispatcher
import com.example.core.shared.intent.UiIntent
import com.example.core.shared.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(
    private val intentDispatcher: IntentDispatcher,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    private val _pageCount = MutableStateFlow<Int>(0)
    val pageCount = _pageCount.asStateFlow()

    private var currentPage = 1
    private var isLoading = false
    private var hasMorePages = true

    fun onIntent(intent: UiIntent) {
        viewModelScope.launch {
            when (intent) {
                is UiIntent.FetchPopularShows -> {
                    if (!isLoading && hasMorePages) {
                        isLoading = true
                        when (val shows = intentDispatcher.dispatch(intent)) {
                            is UiState.ShowsListSuccess -> {
                                if (currentPage == 1) {
                                    _state.value = shows
                                } else {
                                    val currentShows = (_state.value as? UiState.ShowsListSuccess)?.result ?: emptyList()
                                    _state.value = UiState.ShowsListSuccess(
                                        result = currentShows + shows.result,
                                        currentPage = shows.currentPage,
                                        totalPages = shows.totalPages
                                    )
                                }
                                currentPage = shows.currentPage + 1
                                _pageCount.value = currentPage
                                hasMorePages = shows.currentPage < shows.totalPages
                            }
                            is UiState.Error -> {
                                _state.value = shows
                            }
                            else -> {}
                        }
                        isLoading = false
                    }
                }
                else -> {}
            }
        }
    }

    fun loadMoreShows(page: Int) {
        onIntent(UiIntent.FetchPopularShows(page))
    }
}