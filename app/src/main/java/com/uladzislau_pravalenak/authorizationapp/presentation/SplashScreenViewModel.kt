package com.uladzislau_pravalenak.authorizationapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.onboarding.data.OnboardingRepository
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
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
    repository: OnboardingRepository
) : ViewModel() {


    init {
        repository.isOnboardingPassed
            .map { isPassed ->
                if (isPassed) AppFlowRoutes.SIGN_IN.name
                else AppFlowRoutes.ONBOARDING.name
            }
            .flowOn(Dispatchers.Default)
            .onEach { destination -> state.value = destination }
            .launchIn(viewModelScope)

    }

    val state: MutableStateFlow<String> = MutableStateFlow("")
}