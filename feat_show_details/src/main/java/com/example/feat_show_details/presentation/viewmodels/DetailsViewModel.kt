package com.example.feat_show_details.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.shared.state.UiState
import com.example.data.source.repository.IShowsDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val showsRepository: IShowsDetailsRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    fun getShowDetails(id: Int) {
        viewModelScope.launch {
            _state.value = UiState.Loading
            when (val result = showsRepository.getShowDetails(id)) {
                is UiState.ShowSuccess -> {
                    _state.value = result
                }
                is UiState.Error -> {
                    _state.value = result
                }
                else -> {
                    _state.value = UiState.Error(com.example.core.common.Errors.Exception("Unknown error occurred"))
                }
            }
        }
    }
} 