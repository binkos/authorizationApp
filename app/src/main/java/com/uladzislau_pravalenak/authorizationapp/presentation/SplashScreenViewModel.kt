package com.uladzislau_pravalenak.authorizationapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.onboarding.data.StartDestinationRepository
import com.uladzislau_pravalenak.authorizationapp.presentation.model.SplashScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    repository: StartDestinationRepository
) : ViewModel() {

    init {
        repository
            .startDestination
            .map { destination -> SplashScreenState(false, destination) }
            .flowOn(Dispatchers.Default)
            .onEach { newState -> state.value = newState }
            .launchIn(viewModelScope)
    }

    val state: MutableStateFlow<SplashScreenState> = MutableStateFlow(SplashScreenState())
}