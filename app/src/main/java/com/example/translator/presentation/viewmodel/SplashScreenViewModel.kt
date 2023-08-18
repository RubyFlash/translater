package com.example.translator.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.domain.repository.DataStoreRepository
import com.example.translator.presentation.navigation.NavRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val repository: DataStoreRepository
): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(NavRoute.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.readOnBoardingState().collect {completed ->
                if (completed) {
                    _startDestination.value = NavRoute.Home.route
                } else {
                    _startDestination.value = NavRoute.OnBoarding.route
                }
            }
            _isLoading.value = false
        }
    }
}