package com.samsoncj.sampleecommerce.presentation.Home.logic

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samsoncj.sampleecommerce.features.domain.use_case.EcommerceUseCases
import com.samsoncj.sampleecommerce.features.util.OverAllState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val ecommerceUseCases: EcommerceUseCases
):ViewModel() {

    private val _state = mutableStateOf(EcommerceState())
    val state: State<EcommerceState> = _state

    private var ecommerceJob:Job?  = null

    fun getProducts() {
        ecommerceJob?.cancel()
        ecommerceJob = viewModelScope.launch {
            ecommerceUseCases.getProducts.invoke().onEach { result ->
                when(result) {
                    is OverAllState.Success -> {
                        _state.value = state.value.copy(
                            data = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is OverAllState.Loading -> {
                        _state.value = state.value.copy(
                            data = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                    is OverAllState.Error -> {
                        _state.value = state.value.copy(
                            data = result.data ?: emptyList(),
                            isLoading = false
                        )

                    }
                }
            }
        }
    }
}