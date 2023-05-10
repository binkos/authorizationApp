package com.uladzislau_pravalenak.authorizationapp.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.domain.StartDestinationRepository
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val startDestinationRepository: StartDestinationRepository
) : ViewModel() {

    val actions: MutableSharedFlow<OnboardingAction> = MutableSharedFlow()

    fun sendEvent(event: OnboardingEvent) {
        viewModelScope.launch {
            startDestinationRepository.setStartDestination(AppFlowRoutes.SIGN_IN.name)
            val action = when (event) {
                OnboardingEvent.OnSignInClicked -> OnboardingAction.NavigateToSignIn
                OnboardingEvent.OnSignUpClicked -> OnboardingAction.NavigateToSignUp
            }

            actions.emit(action)
        }
    }
}