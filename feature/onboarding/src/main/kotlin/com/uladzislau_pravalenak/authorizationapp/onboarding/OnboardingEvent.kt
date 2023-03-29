package com.uladzislau_pravalenak.authorizationapp.onboarding

sealed class OnboardingEvent {

    object OnSignInClicked : OnboardingEvent()
    object OnSignUpClicked : OnboardingEvent()
}
