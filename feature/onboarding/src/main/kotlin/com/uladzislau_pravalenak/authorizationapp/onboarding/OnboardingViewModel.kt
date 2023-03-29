package com.uladzislau_pravalenak.authorizationapp.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.onboarding.data.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : ViewModel() {

    val events: MutableSharedFlow<OnboardingAction> = MutableSharedFlow()

    fun sendEvent(event: OnboardingEvent) {
        viewModelScope.launch {
            onboardingRepository.setOnboardingPassed(true)
            val action = when(event){
                OnboardingEvent.OnSignInClicked -> OnboardingAction.NavigateToSignIn
                OnboardingEvent.OnSignUpClicked -> OnboardingAction.NavigateToSignUp
            }

            events.emit(action)
        }
    }
}